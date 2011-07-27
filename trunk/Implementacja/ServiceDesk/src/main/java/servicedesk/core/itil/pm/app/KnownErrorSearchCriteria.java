/**
 * 
 */
package servicedesk.core.itil.pm.app;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.itil.pm.domain.KnownError;
import servicedesk.core.itil.pm.domain.ProblemCategory;

/** 
 * <!-- begin-UML-doc -->
 * Klasa reprezentujaca kryterium wyszukiwania problemow
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class KnownErrorSearchCriteria implements SearchCriteria<KnownError>{
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
	 * @param problem
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean match(KnownError knownError) {
		return true;
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(category != null) criteria.add(Restrictions.eq("category", category));
		if(subject != null) criteria.add(Restrictions.like("subject", "%" + subject + "%"));
	}
}