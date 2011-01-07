/**
 * 
 */
package sd.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.pm.domain.ProblemUrgency;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemUrgencyDao extends GenericInMemoryDao<ProblemUrgency,String> implements
		ProblemUrgencyDao {

    public InMemoryProblemUrgencyDao() {
        super(ProblemUrgency.class,String.class);
    }

	@Override
	protected List<ProblemUrgency> initValues() {
		return Arrays.asList(
						new ProblemUrgency[] {
								new ProblemUrgency("CAT1", "Hardware"),
								new ProblemUrgency("CAT2", "Software"),
						}
		);
	}
}