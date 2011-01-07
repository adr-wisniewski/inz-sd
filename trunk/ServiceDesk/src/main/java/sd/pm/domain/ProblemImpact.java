/**
 * 
 */
package sd.pm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "IMPACT_TYPES_PM")
public class ProblemImpact implements DictionaryProperty<String>, Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Id    
    @Column(name = "IMPACT_CODE")
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
		ProblemImpact other = (ProblemImpact) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	public ProblemImpact() {
		//nothing
	}
	
	public ProblemImpact(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

    @Override
    public String getId() {
        return getCode();
    }

    @Override
    public void setId(String id) {
        setCode(id);
    }
	
	
}