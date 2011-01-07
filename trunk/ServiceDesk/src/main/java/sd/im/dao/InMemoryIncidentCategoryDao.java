/**
 * 
 */
package sd.im.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.im.domain.IncidentCategory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

public class InMemoryIncidentCategoryDao extends GenericInMemoryDao<IncidentCategory> implements
		IncidentCategoryDao {

	@Override
	protected List<IncidentCategory> initValues() {

		return Arrays.asList(
						new IncidentCategory[] {
								new IncidentCategory("CAT1", "Hardware"),
								new IncidentCategory("CAT2", "Software"),
						}
		);
	}

	public IncidentCategory findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}