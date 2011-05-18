package servicedesk.core.base.signal.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import servicedesk.infrastructure.interfaces.domain.DictionaryProperty;

@Entity
@Table(name="SIGNAL_OBJECT_TYPES")
public class SignalObjectType implements DictionaryProperty<String>, Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@Column(name="OBJECT_CODE")
	private String code;
	
	@Column(name="VIEW_NAME")
	private String viewName;
	
	@Column(name="ID_COLUMN_NAME")
	private String idColumnName;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="objectType")
	private List<SignalObjectAttributeType> attributeTypes = new LinkedList<SignalObjectAttributeType>();
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DETAILS_URL")
	private String detailsURL;
	
    @Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getIdColumnName() {
		return idColumnName;
	}

	public void setIdColumnName(String idColumnName) {
		this.idColumnName = idColumnName;
	}
	
	public List<SignalObjectAttributeType> getAttributeTypes() {
		return attributeTypes;
	}

	public void setAttributeTypes(List<SignalObjectAttributeType> attributeTypes) {
		this.attributeTypes = attributeTypes;
	}
	
    @Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDetailsURL() {
		return detailsURL;
	}

	public void setDetailsURL(String detailsURL) {
		this.detailsURL = detailsURL;
	}

	@Override
	public String toString() {
		return "SignalObjectType [code="
				+ code + ", idColumnName=" + idColumnName + ", name=" + name
				+ ", viewName=" + viewName + "]";
	}

    @Override
    public String getId() {
        return getCode();
    }

    public void setId(String id) {
        setCode(id);
    }
}
