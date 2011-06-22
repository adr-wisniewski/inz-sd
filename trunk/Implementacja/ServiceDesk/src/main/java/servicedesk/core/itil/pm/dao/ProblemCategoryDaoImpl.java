/**
 * 
 */
package servicedesk.core.itil.pm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.itil.pm.domain.ProblemCategory;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class ProblemCategoryDaoImpl extends GenericHibernateDao<ProblemCategory,String> implements ProblemCategoryDao {

}