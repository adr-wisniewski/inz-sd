/**
 * 
 */
package servicedesk.core.itil.im.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.itil.im.domain.Incident;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentDao implements IncidentDao {
	private List<Incident> incidents;
	private static int INCIDENT_ID_SEQUENCE = 1;
	
	public InMemoryIncidentDao() {
		this.incidents = new LinkedList<Incident>();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentDao#getById(Integer id)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Incident getById(Integer id) {
		for(Incident i : incidents) {
			if(i.getId().equals(id)) {
				return i;
			}
		}
		
		return null;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentDao#save(Incident incident)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void save(Incident incident) {
		if(!incidents.contains(incident)) {
			incident.setId(INCIDENT_ID_SEQUENCE++);
			incident.setCreationDate(new Date());
			incidents.add(incident);
		}
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentDao#getAll()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Incident> getAll() {
		return incidents;
	}

	public List<Incident> search(SearchCriteria<Incident> searchCriteria) {
		List<Incident> result = new LinkedList<Incident>();
        
        for(Incident i : incidents) {
                if(searchCriteria.match(i)) {
                        result.add(i);
                }
        }
        
        return result;
	}
}