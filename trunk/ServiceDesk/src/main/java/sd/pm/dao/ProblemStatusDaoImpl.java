/**
 * 
 */
package sd.pm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.pm.domain.ProblemStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class ProblemStatusDaoImpl extends GenericHibernateDao<ProblemStatus> implements ProblemStatusDao {

	public ProblemStatusDaoImpl() {
		super(ProblemStatus.class);
	}

}