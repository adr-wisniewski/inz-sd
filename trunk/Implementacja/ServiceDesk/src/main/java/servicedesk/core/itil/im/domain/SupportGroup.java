/**
 * 
 */
package servicedesk.core.itil.im.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "SUPPORT_GROUPS")
public class SupportGroup implements DomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "group_seq", sequenceName = "SUPPORT_GROUP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
	@Column(name="GROUP_ID")
	private Integer id;
	
    @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Column(name = "NAME")
	private String name;

	/** 
	 * /**
	 *  * @return the name
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getName() {
		// begin-user-code
		return name;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param name the name to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setName(String name) {
		// begin-user-code
		this.name = name;
		// end-user-code
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MANAGER_ID")
	private Employee manager;
	
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="GROUP_MEMBER", joinColumns = { 
        @JoinColumn(name="GROUP_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="EMPLOYEE_ID", nullable=false, updatable=false) })
	private List<Employee> members;

	public List<Employee> getMembers() {
		return members;
	}

	public void setMembers(List<Employee> members) {
		this.members = members;
	}
}