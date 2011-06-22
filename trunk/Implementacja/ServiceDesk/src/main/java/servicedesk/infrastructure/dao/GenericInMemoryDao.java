/**
 * 
 */
package servicedesk.infrastructure.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataRetrievalFailureException;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.infrastructure.util.GenericUtil;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @param <Type> 
 * @param <Id> 
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
abstract public class GenericInMemoryDao<Type extends DomainObject<Id>, Id extends Serializable>  {

    @SuppressWarnings("unchecked")
        private Class<Type> typeClass = (Class<Type>)GenericUtil
            .getTypeArgument(GenericInMemoryDao.class, getClass(), 0);

    @SuppressWarnings("unchecked")
        private Class<Id> idClass = (Class<Id>)GenericUtil
            .getTypeArgument(GenericInMemoryDao.class, getClass(), 1);

	public Class<Type> getTypeClass() {
		return typeClass;
	}

        public Class<Id> getIdClass() {
		return idClass;
	}


        public GenericInMemoryDao() {
            this.values = initValues();
        }

        /**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private List<Type> values;
	
	/** 
         * @param values 
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
        
        public Type load(Id id) {
                Type object = get(id);
                
                if(object == null)
                    throw new DataRetrievalFailureException("Identifier not found:" + id);
            
		return object;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected abstract List<Type> initValues();
}