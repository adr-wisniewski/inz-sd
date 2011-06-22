/**
 * 
 */
package servicedesk.core.itil.im.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.im.domain.IncidentUrgency;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentUrgencyDao extends GenericInMemoryDao<IncidentUrgency,String> implements
		IncidentUrgencyDao {

	@Override
	protected List<IncidentUrgency> initValues() {
		return Arrays.asList(
						new IncidentUrgency[] {
								new IncidentUrgency("INCI", "Low"),
								new IncidentUrgency("MEDI", "Medium"),
								new IncidentUrgency("HIGH", "High"),
						}
		);
	}
}