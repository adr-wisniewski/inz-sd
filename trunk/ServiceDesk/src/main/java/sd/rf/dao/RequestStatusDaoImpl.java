/**
 * 
 */
package sd.rf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.rf.domain.RequestStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class RequestStatusDaoImpl extends GenericHibernateDao<RequestStatus> implements RequestStatusDao {

	public RequestStatusDaoImpl() {
		super(RequestStatus.class);
	}

}