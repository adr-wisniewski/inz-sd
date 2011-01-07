/**
 * 
 */
package sd.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.pm.domain.ProblemPriority;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemPriorityDao extends GenericInMemoryDao<ProblemPriority,String> implements
		ProblemPriorityDao {
    public InMemoryProblemPriorityDao() {
        super(ProblemPriority.class,String.class);
    }

	@Override
	protected List<ProblemPriority> initValues() {
		return Arrays.asList(
						new ProblemPriority[] {
								new ProblemPriority("CAT1", "Hardware"),
								new ProblemPriority("CAT2", "Software"),
						}
		);
	}
}