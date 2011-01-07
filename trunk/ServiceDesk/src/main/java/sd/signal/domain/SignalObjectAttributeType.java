package sd.signal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SIGNAL_OBJECT_ATTRIBUTE_TYPES")
public class SignalObjectAttributeType {
	@Id
	@Column(name="ATTRIBUTE_CODE")
	private String code;
	
	@Column(name="ATTRIBUTE_NAME")
	private String name;
		
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OBJECT_CODE")
	private SignalObjectType objectType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SignalObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(SignalObjectType objectType) {
		this.objectType = objectType;
	}

	@Override
	public String toString() {
		return "SignalObjectAttributeType [code=" + code + ", name=" + name
				+ ", objectType=" + objectType + "]";
	}
}
