/**
 * 
 */
package sd.pm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.pm.domain.Problem;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Repository
@Transactional
public class ProblemDaoImpl extends GenericHibernateDao<Problem,Integer> implements ProblemDao {
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemDao#getById(Integer id)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
        @Override
	public Problem getById(Integer id) {
		List<Problem> result = this.findByNamedQuery("Problem.get", id);
		
		if(result.size() == 1) {
			return result.get(0);
		}
		
		return null;
	}

}