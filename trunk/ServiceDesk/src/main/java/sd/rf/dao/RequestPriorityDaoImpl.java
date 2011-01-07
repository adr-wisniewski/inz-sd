/**
 * 
 */
package sd.rf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.rf.domain.RequestPriority;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class RequestPriorityDaoImpl extends GenericHibernateDao<RequestPriority,String> implements RequestPriorityDao {

	public RequestPriorityDaoImpl() {
		super(RequestPriority.class, String.class);
	}

}