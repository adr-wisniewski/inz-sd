/**
 * 
 */
package servicedesk.core.itil.im.dao;

import java.util.Arrays;
import java.util.List;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.im.domain.IncidentPriority;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentPriorityDao extends GenericInMemoryDao<IncidentPriority, String> implements
		IncidentPriorityDao {

	@Override
	protected List<IncidentPriority> initValues() {
		return Arrays.asList(
						new IncidentPriority[] {
								new IncidentPriority("L", "Low"),
								new IncidentPriority("M", "Medium"),
								new IncidentPriority("H", "High"),
						}
		);
	}
}