package servicedesk.core.base.event.domain;

import java.util.Date;
import java.util.List;

import servicedesk.core.base.comment.domain.Comment;
import servicedesk.core.hr.domain.Employee;

public interface IEvent {

	/** 
	 * /**
	 *  * @return the id
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getId();

	/** 
	 * /**
	 *  * @param id the id to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setId(Integer id);

	/** 
	 * /**
	 *  * @param creationDate the creationDate to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCreationDate(Date creationDate);

	/** 
	 * /**
	 *  * @return the comments
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Comment> getComments();

	/** 
	 * /**
	 *  * @param comments the comments to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setComments(List<Comment> comments);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param comment
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addComment(Comment comment);
	
	/**
	 * 
	 * @param e osoba, ktora dodala zdarzenie
	 */
	public void setAuthor(Employee e);
	
	/**
	 * 
	 * @return osoba, ktora dodala zdarzenie
	 */
	public Employee getAuthor();
	
	/** 
	 * /**
	 *  * @return the history
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
//	public HistoryAction getHistory();

	/** 
	 * /**
	 *  * @param history the history to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
//	public void setHistory(HistoryAction history);

}