/**
 * 
 */
package servicedesk.core.base.comment.domain;

import servicedesk.core.hr.domain.Employee;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import servicedesk.core.itil.im.domain.Incident;
import servicedesk.core.itil.pm.domain.Problem;
import servicedesk.core.itil.rf.domain.ServiceRequest;

import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * Klasa reprezentujaca komentarz do zdarzenia typu: incydent, problem, RFC.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name="COMMENTS")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Id
	@SequenceGenerator(name = "comment_seq", sequenceName = "comment_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
        @Column(name = "COMMENT_ID")
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
	 * tresc wiadomosci
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Column(name = "TEXT")
	private String text;

	/** 
	 * /**
	 *  * @return the text
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getText() {
		// begin-user-code
		return text;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param text the text to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setText(String text) {
		// begin-user-code
		this.text = text;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
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
	 * data dodania wiadomosci
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	/** 
	 * /**
	 *  * @return the creationDate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getCreationDate() {
		// begin-user-code
		return creationDate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param creationDate the creationDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCreationDate(Date creationDate) {
		// begin-user-code
		this.creationDate = creationDate;
		// end-user-code
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="INCIDENT_ID")
	private Incident incident;

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PROBLEM_ID")
	private Problem problem;

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REQUEST_ID")
	private ServiceRequest request;

	public ServiceRequest getRequest() {
		return request;
	}

	public void setRequest(ServiceRequest request) {
		this.request = request;
	}
}