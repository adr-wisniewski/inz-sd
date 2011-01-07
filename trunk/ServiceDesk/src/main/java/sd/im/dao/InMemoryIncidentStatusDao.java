/**
 * 
 */
package sd.im.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.im.domain.IncidentStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentStatusDao extends GenericInMemoryDao<IncidentStatus> implements
		IncidentStatusDao {
	
	@Override
	protected List<IncidentStatus> initValues() {
		return Arrays.asList(
						new IncidentStatus[] {
								new IncidentStatus("OPEN", "Open"),
								new IncidentStatus("CLOS", "Closed"),
								new IncidentStatus("WORK", "Work in progress"),
						}
		);
	}
}