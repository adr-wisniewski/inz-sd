/**
 * 
 */
package sd.im.app;

import java.util.List;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface RequestService {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param searchCriteria
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<Request> search(RequestSearchCriteria searchCriteria);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addRequest(Request request);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Request getRequestById(Integer id);
	/**
	 * 
	 * @param request
	 */
	public void editRequest(Request request);
	
	public List<RequestPriority> getAllPriorities();
	
	public List<RequestStatus> getAllStatuses();
	
	public List<RequestImpact> getAllImpacts();
	/**
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment);
	/**
	 * 
	 * @param request
	 * @return
	 */
	public List<Comment> getRequestComments(Request request);
}