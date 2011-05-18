/**
 * 
 */
package servicedesk.core.itil.im.domain;

import java.io.Serializable;
import servicedesk.infrastructure.interfaces.domain.DictionaryProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "PRIORITY_TYPES_IM")
public class IncidentPriority implements DictionaryProperty<String>, Serializable {
    private static final long serialVersionUID = 1L;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Id
    @Basic(optional = false)
    @Column(name = "PRIORITY_CODE")
	private String code;

	/** 
	 * /**
	 *  * @return the code
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public String getCode() {
		// begin-user-code
		return code;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param code the code to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCode(String code) {
		// begin-user-code
		this.code = code;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Column(name = "NAME")
	private String name;

	/** 
	 * /**
	 *  * @return the name
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
        @Override
	public String getName() {
		// begin-user-code
		return name;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param name the name to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setName(String name) {
		// begin-user-code
		this.name = name;
		// end-user-code
	}
	
	@Column(name = "TARGET_RESOLUTION_TIME")
	private Integer targetResolutionTime;
	
	public Integer getTargetResolutionTime() {
		return targetResolutionTime;
	}

	public void setTargetResolutionTime(Integer targetResolutionTime) {
		this.targetResolutionTime = targetResolutionTime;
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
		IncidentPriority other = (IncidentPriority) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	public IncidentPriority() {
		//nothing
	}
	
	public IncidentPriority(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "IncidentPriority [code=" + code + ", name=" + name + "]";
	}

    @Override
    public String getId() {
        return getCode();
    }

    public void setId(String id) {
        setCode(id);
    }
}