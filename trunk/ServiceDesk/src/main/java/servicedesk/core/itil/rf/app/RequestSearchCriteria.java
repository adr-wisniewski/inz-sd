package servicedesk.core.itil.rf.app;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.hr.domain.Employee;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.rf.domain.RequestCategory;
import servicedesk.core.itil.rf.domain.RequestPriority;
import servicedesk.core.itil.rf.domain.RequestStatus;
import servicedesk.core.itil.rf.domain.ServiceRequest;

public class RequestSearchCriteria implements SearchCriteria<ServiceRequest>{
	private Integer id;
	
	private Date startCreationDate;
	
	private Date endCreationDate;
	
	private RequestCategory category;
	
	private Employee author;
	
	private RequestStatus status;
	
	private RequestPriority priority;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartCreationDate() {
		return startCreationDate;
	}

	public void setStartCreationDate(Date startDate) {
		this.startCreationDate = startDate;
	}

	public Date getEndCreationDate() {
		return endCreationDate;
	}

	public void setEndCreationDate(Date endDate) {
		this.endCreationDate = endDate;
	}

	public RequestCategory getCategory() {
		return category;
	}

	public void setCategory(RequestCategory category) {
		this.category = category;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public RequestPriority getPriority() {
		return priority;
	}

	public void setPriority(RequestPriority priority) {
		this.priority = priority;
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private SupportGroup supportGroup;

	/** 
	 * /**
	 *  * @return the supportGroup
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SupportGroup getSupportGroup() {
		// begin-user-code
		return supportGroup;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param supportGroup the supportGroup to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSupportGroup(SupportGroup supportGroup) {
		// begin-user-code
		this.supportGroup = supportGroup;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Employee supportGroupMember;

	/** 
	 * /**
	 *  * @return the supportGroupMember
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Employee getSupportGroupMember() {
		// begin-user-code
		return supportGroupMember;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param supportGroupMember the supportGroupMember to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSupportGroupMember(Employee supportGroupMember) {
		// begin-user-code
		this.supportGroupMember = supportGroupMember;
		// end-user-code
	}

	public String buildCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(author != null) criteria.add(Restrictions.eq("author", author));
		if(category != null) criteria.add(Restrictions.eq("category", category));
		if(status != null) criteria.add(Restrictions.eq("status", status));
		if(priority != null) criteria.add(Restrictions.eq("priority", priority));
		if(supportGroup != null) criteria.add(Restrictions.eq("supportGroup", supportGroup));
		if(supportGroupMember != null) criteria.add(Restrictions.eq("supportGroupMember", supportGroupMember));
		if(startCreationDate != null) criteria.add(Restrictions.ge("creationDate", startCreationDate));
		if(endCreationDate != null) criteria.add(Restrictions.le("creationDate", endCreationDate));
	}

	public boolean match(ServiceRequest event) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
