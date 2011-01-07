/**
 * 
 */
package sd.im.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.im.domain.Incident;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class IncidentDaoImpl extends GenericHibernateDao<Incident,Integer> implements IncidentDao {

	public IncidentDaoImpl() {
		super(Incident.class, Integer.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentDao#getById(Integer id)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public Incident getById(Integer id) {
		List<Incident> result = this.findByNamedQuery("Incident.get", id);
		
		if(result.size() == 1) {
			return result.get(0);
		}
		
		return null;
	}
}