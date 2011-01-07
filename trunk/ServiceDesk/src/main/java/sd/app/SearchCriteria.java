package sd.app;

import org.hibernate.Criteria;

public interface SearchCriteria<T> {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean match(T event);

	/**
	 * Metoda ustawiajaca kryterium wyszukiwania
	 * 
	 * @param criteria kryterium wyszukiwania
	 */
	public void initCriteria(Criteria criteria);
}