/**
 * 
 */
package servicedesk.core.base.employee.domain;

import javax.persistence.OneToOne;
import servicedesk.core.base.security.domain.EmployeeUser;
import servicedesk.core.base.security.domain.Role;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

import servicedesk.core.itil.scm.domain.Service;
import servicedesk.core.base.security.domain.Person;

/** 
 * <!-- begin-UML-doc -->
 * <p>
 *     Klasa reprezentujaca pracownika
 * </p>
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "EMPLOYEES")
@NamedQueries({
    @NamedQuery(name = "Employee.get", query = "SELECT e FROM Employee e WHERE e.id = ?")
/*,@NamedQuery(name = "Employee.findByLogin", query = "SELECT e FROM Employee e WHERE e.login = ?")*/
})
public class Employee implements DomainObject<Integer>, Person, Serializable {

    private static final long serialVersionUID = 1L;
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @OneToOne(mappedBy = "employee")
    private EmployeeUser user;

    /** 
     * /**
     *  * @return the id
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
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
    /*@Column(name = "LOGIN")
    private String login;
    
    public String getLogin() {
    return login;
    }
    
    public void setLogin(String login) {
    this.login = login;
    }*/
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "NAME")
    private String firstname;

    /** 
     * /**
     *  * @return the firstname
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public String getFirstname() {
        // begin-user-code
        return firstname;
        // end-user-code
    }

    /** 
     * /**
     *  * @param firstname the firstname to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setFirstname(String firstname) {
        // begin-user-code
        this.firstname = firstname;
        // end-user-code
    }
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "SURNAME")
    private String lastname;

    /** 
     * /**
     *  * @return the lastname
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public String getLastname() {
        // begin-user-code
        return lastname;
        // end-user-code
    }

    /** 
     * /**
     *  * @param lastname the lastname to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setLastname(String lastname) {
        // begin-user-code
        this.lastname = lastname;
        // end-user-code
    }
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    /** 
     * /**
     *  * @return the phoneNumber
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getPhoneNumber() {
        // begin-user-code
        return phoneNumber;
        // end-user-code
    }

    /** 
     * /**
     *  * @param phoneNumber the phoneNumber to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPhoneNumber(String phoneNumber) {
        // begin-user-code
        this.phoneNumber = phoneNumber;
        // end-user-code
    }
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    /** 
     * /**
     *  * @return the mobilePhone
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getMobilePhone() {
        // begin-user-code
        return mobilePhone;
        // end-user-code
    }

    /** 
     * /**
     *  * @param mobilePhone the mobilePhone to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setMobilePhone(String mobilePhone) {
        // begin-user-code
        this.mobilePhone = mobilePhone;
        // end-user-code
    }
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "EMAIL")
    private String email;

    /** 
     * /**
     *  * @return the email
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getEmail() {
        // begin-user-code
        return email;
        // end-user-code
    }

    /** 
     * /**
     *  * @param email the email to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setEmail(String email) {
        // begin-user-code
        this.email = email;
        // end-user-code
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_CODE")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
    //@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    //@JoinTable(name="EMPLOYEE_ROLE", joinColumns = {
    //@JoinColumn(name="EMPLOYEE_ID", nullable=false, updatable=false) }, inverseJoinColumns = {
    //@JoinColumn(name="ROLE_CODE", nullable=false, updatable=false) })
    @Transient
    private List<Role> authorities = new LinkedList<Role>();

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public void clearAuthorities() {
        if (authorities != null) {
            authorities.clear();
        }
    }
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE_SERVICE", joinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "SERVICE_ID", nullable = false, updatable = false)})
    private Set<Service> services = new HashSet<Service>();

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Employee [email=" + email + ", firstname=" + firstname
                + ", id=" + id + ", lastname=" + lastname //+ ", login=" + login
                + ", mobilePhone=" + mobilePhone + ", phoneNumber="
                + phoneNumber + "]";
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public Employee() {
        //do nothing
    }

    public Employee(Integer id, String firstname, String lastname) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * @return the user
     */
    public EmployeeUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    protected void setUser(EmployeeUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        final Employee other = (Employee) obj;
        if ((this.getId() == null) ? (other.getId() != null) : !this.getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
    
    
}