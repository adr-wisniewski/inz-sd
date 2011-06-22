/**
 * 
 */
package sd.im.impl;

import sd.im.app.RequestDao;
import sd.im.app.Request;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 */
@Repository
public class InMemoryRequestDao implements RequestDao {
	private Set<Request> requests;
	private static int REQUEST_ID_SEQUENCE = 1;
	
	public InMemoryRequestDao() {
		this.requests = new HashSet<Request>();
		
		Request request = null;
		
		request = new Request();
		request.setSubject("r1");
		this.save(request);
		
		request = new Request();
		request.setSubject("r2");
		this.save(request);
	}
	
	
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see RequestDao#getById(Integer id)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Request getById(Integer id) {
		for(Request r : requests) {
			if(r.getId().equals(id)) {
				return r;
			}
		}
		
		return null;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see RequestDao#save(Request request)
	 * 
	 */
	public void save(Request request) {
		if(!requests.contains(request)) {
			request.setId(REQUEST_ID_SEQUENCE++);
			requests.add(request);
		}
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see RequestDao#findAll()
	 * 
	 */
	public Set<Request> findAll() {
		return requests;
	}
}