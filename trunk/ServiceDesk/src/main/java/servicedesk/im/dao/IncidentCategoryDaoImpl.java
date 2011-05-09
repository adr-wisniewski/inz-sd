/**
 * 
 */
package servicedesk.im.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.im.domain.IncidentCategory;
import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class IncidentCategoryDaoImpl extends GenericHibernateDao<IncidentCategory,String> implements IncidentCategoryDao {

}