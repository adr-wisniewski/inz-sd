/**
 * 
 */
package sd.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.pm.domain.ProblemStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemStatusDao extends GenericInMemoryDao<ProblemStatus> implements
		ProblemStatusDao {
	
	@Override
	protected List<ProblemStatus> initValues() {
		return Arrays.asList(
						new ProblemStatus[] {
								new ProblemStatus("CAT1", "Hardware"),
								new ProblemStatus("CAT2", "Software"),
						}
		);
	}
}