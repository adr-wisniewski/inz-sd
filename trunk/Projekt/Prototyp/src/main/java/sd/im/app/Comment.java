/**
 * 
 */
package sd.im.app;

import sd.Employee;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Comment {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
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
	private Integer requestId;

	/** 
	 * /**
	 *  * @return the incident
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getRequestId() {
		// begin-user-code
		return requestId;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param incident the incident to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRequestId(Integer requestId) {
		// begin-user-code
		this.requestId = requestId;
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

	@Override
	public String toString() {
		return "Comment [author=" + author + ", creationDate=" + creationDate
				+ ", requestId=" + requestId + ", text=" + text + "]";
	}
	
}