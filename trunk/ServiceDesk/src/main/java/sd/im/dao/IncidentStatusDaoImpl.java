/**
 * 
 */
package sd.im.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.im.domain.IncidentStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class IncidentStatusDaoImpl extends GenericHibernateDao<IncidentStatus> implements IncidentStatusDao {

	public IncidentStatusDaoImpl() {
		super(IncidentStatus.class);
	}

}