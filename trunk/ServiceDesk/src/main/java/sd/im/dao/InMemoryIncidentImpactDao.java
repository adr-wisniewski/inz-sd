/**
 * 
 */
package sd.im.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.im.domain.IncidentImpact;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentImpactDao extends GenericInMemoryDao<IncidentImpact> implements
		IncidentImpactDao {

	@Override
	protected List<IncidentImpact> initValues() {
		return 
				Arrays.asList(
						new IncidentImpact[] {
								new IncidentImpact("U", "Affects User"),
								new IncidentImpact("G", "Affects Group"),
						}
		);
	}
}