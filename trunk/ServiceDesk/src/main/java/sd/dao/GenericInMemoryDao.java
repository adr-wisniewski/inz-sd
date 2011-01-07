/**
 * 
 */
package sd.dao;

import java.io.Serializable;
import java.util.List;
import sd.infrastructure.dao.Dao;
import sd.infrastructure.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
abstract public class GenericInMemoryDao<Type extends DomainObject<Id>, Id extends Serializable> implements Dao<Type, Id> {

        protected Class<Type> typeClass;
        protected Class<Id> idClass;

        public GenericInMemoryDao(Class<Type> typeClass, Class<Id> idClass) {
            this.typeClass = typeClass;
            this.idClass = idClass;
            this.values = initValues();
        }

        @Override
        public Class<Type> getTypeClass() {
            return typeClass;
        }

        @Override
        public Class<Id> getIdClass() {
            return idClass;
        }


        /**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private List<Type> values;
	
	/** 
	 * /**
	 *  * @param values the values to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setValues(List<Type> values) {
		// begin-user-code
		this.values = values;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Type> getAll() {
		return values;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param object
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void save(Type object) {
		if(!values.contains(object)) {
			values.add(object);
		}
	}
	
	public Type get(Id id) {
		return values.get(0);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	abstract protected List<Type> initValues();
}