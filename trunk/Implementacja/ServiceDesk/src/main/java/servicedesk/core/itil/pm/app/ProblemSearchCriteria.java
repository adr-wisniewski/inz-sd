/**
 * 
 */
package servicedesk.core.itil.pm.app;

import servicedesk.core.itil.pm.domain.ProblemCategory;
import servicedesk.core.itil.pm.domain.ProblemStatus;
import servicedesk.core.itil.pm.domain.ProblemUrgency;
import servicedesk.core.itil.pm.domain.ProblemImpact;
import servicedesk.core.itil.pm.domain.ProblemPriority;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.pm.domain.Problem;

/** 
 * <!-- begin-UML-doc -->
 * Klasa reprezentujaca kryterium wyszukiwania problemow
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ProblemSearchCriteria implements SearchCriteria<Problem>{
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
	private ProblemCategory category;

	/** 
	 * /**
	 *  * @return the category
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ProblemCategory getCategory() {
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
	public void setCategory(ProblemCategory category) {
		// begin-user-code
		this.category = category;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ProblemStatus status;

	/** 
	 * /**
	 *  * @return the status
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ProblemStatus getStatus() {
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
	public void setStatus(ProblemStatus status) {
		// begin-user-code
		this.status = status;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ProblemUrgency urgency;

	/** 
	 * /**
	 *  * @return the urgency
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ProblemUrgency getUrgency() {
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
	public void setUrgency(ProblemUrgency urgency) {
		// begin-user-code
		this.urgency = urgency;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ProblemImpact impact;

	/** 
	 * /**
	 *  * @return the impact
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ProblemImpact getImpact() {
		// begin-user-code
		return impact;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param impact the impact to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImpact(ProblemImpact impact) {
		// begin-user-code
		this.impact = impact;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ProblemPriority priority;

	/** 
	 * /**
	 *  * @return the priority
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ProblemPriority getPriority() {
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
	public void setPriority(ProblemPriority priority) {
		// begin-user-code
		this.priority = priority;
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private SupportGroup supportGroup;

	private Boolean knownError;
	
	public Boolean getKnownError() {
		return knownError;
	}

	public void setKnownError(Boolean knownError) {
		this.knownError = knownError;
	}

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
	 * @param problem
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean match(Problem problem) {
		if(subject != null && !problem.getSubject().contains(subject)) {
			return false;
		}
		
		if(priority != null && !problem.getPriority().equals(priority)) {
			return false;
		}
		
		return true;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String buildCondition() {
		// begin-user-code
		// TODO2 Auto-generated method stub
		return null;
		// end-user-code
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(author != null) criteria.add(Restrictions.eq("author", author));
		if(category != null) criteria.add(Restrictions.eq("category", category));
		if(impact != null) criteria.add(Restrictions.eq("impact", impact));
		if(priority != null) criteria.add(Restrictions.eq("priority", priority));
		if(status != null) criteria.add(Restrictions.eq("status", status));
		if(subject != null) criteria.add(Restrictions.like("subject", "%" + subject + "%"));
		if(knownError != null) criteria.add(Restrictions.eq("knownError", knownError));
		if(supportGroup != null) criteria.add(Restrictions.eq("supportGroup", supportGroup));
		if(supportGroupMember != null) criteria.add(Restrictions.eq("supportGroupMember", supportGroupMember));
	}
}