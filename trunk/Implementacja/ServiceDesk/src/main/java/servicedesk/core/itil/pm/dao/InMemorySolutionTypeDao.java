/**
 * 
 */
package servicedesk.core.itil.pm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import servicedesk.infrastructure.dao.GenericInMemoryDao;
import servicedesk.core.itil.pm.domain.SolutionType;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemorySolutionTypeDao extends GenericInMemoryDao<SolutionType,String> implements
		SolutionTypeDao {

    @Override
    protected List<SolutionType> initValues() {
            return Arrays.asList(
                                            new SolutionType[] {
                                                            new SolutionType("CAT1", "Hardware"),
                                                            new SolutionType("CAT2", "Software"),
                                            }
            );
    }
}