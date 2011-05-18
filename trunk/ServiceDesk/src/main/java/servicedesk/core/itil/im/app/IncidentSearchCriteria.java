/**
 * 
 */
package servicedesk.core.itil.im.app;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.hr.domain.Employee;
import servicedesk.core.itil.im.domain.Incident;
import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.core.itil.im.domain.IncidentImpact;
import servicedesk.core.itil.im.domain.IncidentPriority;
import servicedesk.core.itil.im.domain.IncidentSource;
import servicedesk.core.itil.im.domain.IncidentStatus;
import servicedesk.core.itil.im.domain.IncidentUrgency;
import servicedesk.core.itil.im.domain.SupportGroup;

/** 
 * <!-- begin-UML-doc -->
 * Klasa reprezentujaca kryterium wyszukiwania incydentow.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class IncidentSearchCriteria implements SearchCriteria<Incident> {
	Logger logger = Logger.getLogger(IncidentSearchCriteria.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer id;

	/** 
	 * /**
	 *  * @return the id
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getId() {
		// begin-user-code
		return id;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param id the id to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setId(Integer id) {
		// begin-user-code
		this.id = id;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String subject;

	/** 
	 * /**
	 *  * @return the subject
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getSubject() {
		// begin-user-code
		return subject;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param subject the subject to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSubject(String subject) {
		// begin-user-code
		this.subject = subject;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Employee author;

	/** 
	 * /**
	 *  * @return the author
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Employee getAuthor() {
		// begin-user-code
		return author;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param author the author to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setAuthor(Employee author) {
		// begin-user-code
		this.author = author;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date startCreationDate;

	/** 
	 * /**
	 *  * @return the startCreationDate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getStartCreationDate() {
		// begin-user-code
		return startCreationDate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param startCreationDate the startCreationDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setStartCreationDate(Date startCreationDate) {
		// begin-user-code
		this.startCreationDate = startCreationDate;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date endCreationDate;

	/** 
	 * /**
	 *  * @return the endCreationDate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getEndCreationDate() {
		// begin-user-code
		return endCreationDate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param endCreationDate the endCreationDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEndCreationDate(Date endCreationDate) {
		// begin-user-code
		this.endCreationDate = endCreationDate;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date startClosureDate;

	/** 
	 * /**
	 *  * @return the startClosureDate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getStartClosureDate() {
		// begin-user-code
		return startClosureDate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param startClosureDate the startClosureDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setStartClosureDate(Date startClosureDate) {
		// begin-user-code
		this.startClosureDate = startClosureDate;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date endClosureDate;

	/** 
	 * /**
	 *  * @return the endClosureDate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getEndClosureDate() {
		// begin-user-code
		return endClosureDate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param endClosureDate the endClosureDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEndClosureDate(Date endClosureDate) {
		// begin-user-code
		this.endClosureDate = endClosureDate;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentPriority priority;

	/** 
	 * /**
	 *  * @return the priority
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentPriority getPriority() {
		// begin-user-code
		return priority;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param priority the priority to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPriority(IncidentPriority priority) {
		// begin-user-code
		this.priority = priority;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentCategory category;

	/** 
	 * /**
	 *  * @return the category
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentCategory getCategory() {
		// begin-user-code
		return category;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param category the category to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCategory(IncidentCategory category) {
		// begin-user-code
		this.category = category;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentStatus status;

	/** 
	 * /**
	 *  * @return the status
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentStatus getStatus() {
		// begin-user-code
		return status;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param status the status to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setStatus(IncidentStatus status) {
		// begin-user-code
		this.status = status;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentUrgency urgency;

	/** 
	 * /**
	 *  * @return the urgency
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentUrgency getUrgency() {
		// begin-user-code
		return urgency;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param urgency the urgency to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setUrgency(IncidentUrgency urgency) {
		// begin-user-code
		this.urgency = urgency;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentSource source;

	/** 
	 * /**
	 *  * @return the source
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentSource getSource() {
		// begin-user-code
		return source;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param source the source to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSource(IncidentSource source) {
		// begin-user-code
		this.source = source;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IncidentImpact impact;

	/** 
	 * /**
	 *  * @return the source
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IncidentImpact getImpact() {
		// begin-user-code
		return impact;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param source the source to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImpact(IncidentImpact impact) {
		// begin-user-code
		this.impact = impact;
		// end-user-code
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

	private boolean notAssigned = false;
	
	public boolean isNotAssigned() {
		return notAssigned;
	}

	public void setNotAssigned(boolean notAssigned) {
		this.notAssigned = notAssigned;
	}

	/* (non-Javadoc)
	 * @see servicedesk.im.app.EventSearchCriteria#match(servicedesk.im.domain.Incident)
	 */
	public boolean match(Incident incident) {
		//logger.info("match() - incident: " + incident);
		//logger.info("match() - subject: " + subject + " priority: " + priority);
		
		if(subject != null && !incident.getSubject().contains(subject)) {
			return false;
		}
		
		if(priority != null && !priority.equals(incident.getPriority())) {
			return false;
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see servicedesk.im.app.EventSearchCriteria#buildCondition()
	 */
	public String buildCondition() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(author != null) criteria.add(Restrictions.eq("author", author));
		if(category != null) criteria.add(Restrictions.eq("category", category));
		if(impact != null) criteria.add(Restrictions.eq("impact", impact));
		if(urgency != null) criteria.add(Restrictions.eq("urgency", urgency));
		if(priority != null) criteria.add(Restrictions.eq("priority", priority));
		if(status != null) criteria.add(Restrictions.eq("status", status));
		if(subject != null) criteria.add(Restrictions.like("subject", "%" + subject + "%"));
		if(supportGroup != null) criteria.add(Restrictions.eq("supportGroup", supportGroup));
		if(supportGroupMember != null) criteria.add(Restrictions.eq("supportGroupMember", supportGroupMember));
		if(startCreationDate != null) criteria.add(Restrictions.ge("creationDate", startCreationDate));
		if(endCreationDate != null) criteria.add(Restrictions.le("creationDate", endCreationDate));
		if(notAssigned) criteria.add(Restrictions.isNull("supportGroupMember"));
	}
}