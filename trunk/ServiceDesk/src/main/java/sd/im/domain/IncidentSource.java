/**
 * 
 */
package sd.im.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

/** 
 * <!-- begin-UML-doc -->
 * <p>
 *    Zrodlo dodania: poprzez strone www, telefonicznie, email.
 * </p>
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "SOURCE_TYPES_IM")
public class IncidentSource implements DictionaryProperty<String>, Serializable {
	public static final IncidentSource EVENT = new IncidentSource("EVNT", "Event");
	public static final IncidentSource WEB_FORM = new IncidentSource("FORM", "Web-Form");
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Id
    @Basic(optional = false)
    @Column(name = "SOURCE_CODE")
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
		IncidentSource other = (IncidentSource) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	public IncidentSource() {
		//nothing
	}
	
	public IncidentSource(String code, String name) {
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