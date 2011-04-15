/**
 * 
 */
package servicedesk.pm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.pm.domain.SolutionType;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class SolutionTypeDaoImpl extends GenericHibernateDao<SolutionType,String> implements SolutionTypeDao {

}