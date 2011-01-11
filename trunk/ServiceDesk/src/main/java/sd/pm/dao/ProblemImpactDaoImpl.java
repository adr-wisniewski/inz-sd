/**
 * 
 */
package sd.pm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.pm.domain.ProblemImpact;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class ProblemImpactDaoImpl extends GenericHibernateDao<ProblemImpact,String> implements ProblemImpactDao {

	public ProblemImpactDaoImpl() {
		super(ProblemImpact.class, String.class);
	}

}