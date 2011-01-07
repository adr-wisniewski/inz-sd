/**
 * 
 */
package sd.dictionary;

import java.util.List;

/** 
 * <!-- begin-UML-doc -->
 * Interfejs dla DAO do atrybutow slownikowych.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DictionaryPropertyDao<P extends DictionaryProperty> {
	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie mozliwe wartosci slownika.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<P> fetchAll();
}