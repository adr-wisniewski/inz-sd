/**
 * 
 */
package sd.im.impl;

import sd.im.app.Comment;
import sd.im.app.CommentDao;
import sd.im.app.RequestImpact;
import sd.im.app.RequestImpactDao;
import sd.im.app.RequestPriority;
import sd.im.app.RequestPriorityDao;
import sd.im.app.RequestService;
import sd.im.app.RequestDao;
import sd.im.app.RequestStatus;
import sd.im.app.RequestStatusDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.im.app.Request;
import sd.im.app.RequestSearchCriteria;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Service
public class RequestServiceImpl implements RequestService {
	private static Logger logger = Logger.getLogger(RequestServiceImpl.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private RequestPriorityDao requestPriorityDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private RequestStatusDao requestStatusDao;
	@Autowired
	private RequestImpactDao requestImpactDao;
	/** 
	 * /**
	 *  * @return the requestDao
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RequestDao getRequestDao() {
		// begin-user-code
		return requestDao;
		// end-user-code
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	/** 
	 * /**
	 *  * @param requestDao the requestDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRequestDao(RequestDao requestDao) {
		// begin-user-code
		this.requestDao = requestDao;
		// end-user-code
	}
	
	public void setRequestPriorityDao(RequestPriorityDao requestPriorityDao) {
		this.requestPriorityDao = requestPriorityDao;
	}

	
	
	public void setRequestStatusDao(RequestStatusDao requestStatusDao) {
		this.requestStatusDao = requestStatusDao;
	}

	public void setRequestImpactDao(RequestImpactDao requestImpactDao) {
		this.requestImpactDao = requestImpactDao;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see RequestService#search(RequestSearchCriteria searchCriteria)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<Request> search(RequestSearchCriteria searchCriteria) {
		if(searchCriteria == null) {
			return null;
		}
		
		
		Set<Request> result =  new HashSet<Request>();
		
		for(Request request : requestDao.findAll()) {

logger.debug(searchCriteria.getSubject() == null);
logger.debug(request.getSubject() == null);

			if(searchCriteria.match(request)) {
				result.add(request);
			}
		}
		
		return result;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see RequestService#addRequest(Request request)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addRequest(Request request) {
		requestDao.save(request);
	}

	public Request getRequestById(Integer id) {
		return requestDao.getById(id);
	}

	public void editRequest(Request request) {
		requestDao.save(request);
	}

	public List<RequestPriority> getAllPriorities() {
		return requestPriorityDao.fetchAll();
	}

	public void addComment(Comment comment) {
		commentDao.save(comment);
	}

	public List<Comment> getRequestComments(Request request) {
		return commentDao.getCommentByRequestId(request.getId());
	}

	public List<RequestStatus> getAllStatuses() {
		return requestStatusDao.fetchAll();
	}

	public List<RequestImpact> getAllImpacts() {
		return requestImpactDao.fetchAll();
	}
}