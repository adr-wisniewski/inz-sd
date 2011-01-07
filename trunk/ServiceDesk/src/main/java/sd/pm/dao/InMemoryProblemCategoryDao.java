/**
 * 
 */
package sd.pm.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.dao.GenericInMemoryDao;
import sd.pm.domain.ProblemCategory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemCategoryDao extends GenericInMemoryDao<ProblemCategory,String> implements
		ProblemCategoryDao {

    public InMemoryProblemCategoryDao() {
        super(ProblemCategory.class,String.class);
    }


    protected List<ProblemCategory> initValues() {
        return Arrays.asList(
            new ProblemCategory[] {
                            new ProblemCategory("CAT1", "Hardware"),
                            new ProblemCategory("CAT2", "Software"),
            }
        );
    }

    public ProblemCategory get(String id) {
            // TODO Auto-generated method stub
            return null;
    }
}