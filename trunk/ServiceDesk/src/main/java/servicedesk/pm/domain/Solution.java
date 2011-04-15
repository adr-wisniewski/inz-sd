/**
 * 
 */
package servicedesk.pm.domain;

import java.util.Date;

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

import servicedesk.domain.Employee;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "SOLUTIONS")
public class Solution {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Id
	@SequenceGenerator(name = "solution_seq", sequenceName = "solution_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solution_seq")
    @Column(name = "SOLUTION_ID")
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
	@Column(name = "SUBJECT")
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
	@Column(name = "DESCRIPTION")
	private String description;

	/** 
	 * /**
	 *  * @return the description
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDescription() {
		// begin-user-code
		return description;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param description the description to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDescription(String description) {
		// begin-user-code
		this.description = description;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	/** 
	 * /**
	 *  * @return the lastUpdate
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getLastUpdate() {
		// begin-user-code
		return lastUpdate;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param lastUpdate the lastUpdate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setLastUpdate(Date lastUpdate) {
		// begin-user-code
		this.lastUpdate = lastUpdate;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SOLUTION_CODE")
	private SolutionType type;

	/** 
	 * /**
	 *  * @return the type
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SolutionType getType() {
		// begin-user-code
		return type;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param type the type to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setType(SolutionType type) {
		// begin-user-code
		this.type = type;
		// end-user-code
	}

	public void setType(String code) {
		if(code.equals(SolutionType.PERMANENT.getCode())) {
			this.type = SolutionType.PERMANENT;
		}
		else if(code.equals(SolutionType.WORKAROUND.getCode())) {
			this.type = SolutionType.WORKAROUND;
		}
		
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
    @JoinColumn(name="AUTHOR")
	private Employee author;

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Solution [author=" + author + ", creationDate=" + creationDate
				+ ", description=" + description + ", id=" + id
				+ ", lastUpdate=" + lastUpdate + ", problem=" + problem
				+ ", subject=" + subject + ", type=" + type + "]";
	}
	
}