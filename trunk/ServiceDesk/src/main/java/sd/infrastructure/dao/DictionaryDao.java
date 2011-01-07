/**
 * 
 */
package sd.infrastructure.dao;

import java.io.Serializable;
import java.util.List;
import sd.dictionary.DictionaryProperty;
import sd.infrastructure.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * Interfejs dla DAO do atrybutow slownikowych.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DictionaryDao<Type extends DictionaryProperty<Id>, Id extends Serializable> extends Dao<Type, Id> {
	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie mozliwe wartosci slownika.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Type> getAll();
}