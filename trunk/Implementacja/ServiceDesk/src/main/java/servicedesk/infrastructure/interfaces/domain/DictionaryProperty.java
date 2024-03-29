/**
 * 
 */
package servicedesk.infrastructure.interfaces.domain;

import java.io.Serializable;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * Interfejs dla atrybutow slownikowych. DictionaryPropertyEditor, wykorzystuje metode getCode().
 * <!-- end-UML-doc -->
 * @param <Id> 
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DictionaryProperty<Id extends Serializable> extends DomainObject<Id> {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getCode();
	
	public String getName();
}