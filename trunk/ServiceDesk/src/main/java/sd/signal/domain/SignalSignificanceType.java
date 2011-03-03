package sd.signal.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="SIGNAL_SIGNIFICANCE_TYPES")
public class SignalSignificanceType implements DictionaryProperty<String>, Serializable {
	@Id
	@Column(name="SIGNIFICANCE_CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CSS_CLASS")
	private String cssClass;
	
    @Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    @Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	@Override
	public String toString() {
		return "SignalSignificanceType [code=" + code + ", name=" + name + "]";
	}

    @Override
    public String getId() {
        return getCode();
    }

    public void setId(String id) {
        setCode(id);
    }
}
