/**
 * 
 */
package sd.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.pm.domain.ProblemImpact;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemImpactDao extends GenericInMemoryDao<ProblemImpact,String> implements ProblemImpactDao {

    public InMemoryProblemImpactDao() {
        super(ProblemImpact.class,String.class);
    }

	@Override
	protected List<ProblemImpact> initValues() {
		return Arrays.asList(
						new ProblemImpact[] {
								new ProblemImpact("CAT1", "Hardware"),
								new ProblemImpact("CAT2", "Software"),
						}
		);
	}
}