/**
 * 
 */
package sd.dictionary;

import java.io.Serializable;
import sd.infrastructure.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * Interfejs dla atrybutow slownikowych. DictionaryPropertyEditor, wykorzystuje metode getCode().
 * <!-- end-UML-doc -->
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