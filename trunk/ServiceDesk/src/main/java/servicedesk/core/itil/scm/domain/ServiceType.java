package servicedesk.core.itil.scm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import servicedesk.infrastructure.interfaces.domain.DictionaryProperty;


@Entity
@Table(name="SERVICE_TYPES")
public class ServiceType implements DictionaryProperty<String>, Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SERVICE_TYPE_CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceType other = (ServiceType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

    @Override
    public String getId() {
        return getCode();
    }

    public void setId(String id) {
        setCode(id);
    }
}
