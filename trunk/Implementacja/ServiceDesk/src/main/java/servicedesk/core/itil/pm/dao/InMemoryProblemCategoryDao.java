/**
 * 
 */
package servicedesk.core.itil.pm.dao;

import java.util.Arrays;
import java.util.List;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.pm.domain.ProblemCategory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemCategoryDao extends GenericInMemoryDao<ProblemCategory,String> implements
		ProblemCategoryDao {

    @Override
    protected List<ProblemCategory> initValues() {
        return Arrays.asList(
            new ProblemCategory[] {
                            new ProblemCategory("CAT1", "Hardware"),
                            new ProblemCategory("CAT2", "Software"),
            }
        );
    }
}