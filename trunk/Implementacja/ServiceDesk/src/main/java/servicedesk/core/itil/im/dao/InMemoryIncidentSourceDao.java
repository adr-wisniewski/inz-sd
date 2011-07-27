/**
 * 
 */
package servicedesk.core.itil.im.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.im.domain.IncidentSource;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryIncidentSourceDao extends GenericInMemoryDao<IncidentSource,String> implements
		IncidentSourceDao {

	@Override
	protected List<IncidentSource> initValues() {
		return Arrays.asList(
						new IncidentSource[] {
								new IncidentSource("MAIL", "e-mail"),
								new IncidentSource("PHON", "Phone"),
								new IncidentSource("WEB", "Web form"),
						}
		);
	}
}