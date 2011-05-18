/**
 * 
 */
package servicedesk.core.itil.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.pm.domain.ProblemPriority;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemPriorityDao extends GenericInMemoryDao<ProblemPriority,String> implements
		ProblemPriorityDao {

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