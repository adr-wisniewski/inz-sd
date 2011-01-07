/**
 * 
 */
package sd.pm.dao;

import java.util.LinkedList;
import java.util.List;

import sd.app.SearchCriteria;
import sd.pm.domain.Problem;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class InMemoryProblemDao implements ProblemDao {
	private static int PROBLEM_ID_SEQUENCE = 1;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private List<Problem> problems;

	public InMemoryProblemDao() {
		this.problems = new LinkedList<Problem>();
	}
	/** 
	 * /**
	 *  * @param problems the problems to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemDao#getAll()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Problem> getAll() {
		return problems;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemDao#getById(Integer id)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Problem getById(Integer id) {
		for(Problem p : problems) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		
		return null;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemDao#save(Problem problem)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void save(Problem problem) {
		if(!problems.contains(problem)) {
			problem.setId(PROBLEM_ID_SEQUENCE++);
			problems.add(problem);
		}
	}
	public List<Problem> search(SearchCriteria<Problem> searchCriteria) {
		List<Problem> result = new LinkedList<Problem>();
        
        for(Problem i : problems) {
                if(searchCriteria.match(i)) {
                        result.add(i);
                }
        }
        
        return result;
	}
}