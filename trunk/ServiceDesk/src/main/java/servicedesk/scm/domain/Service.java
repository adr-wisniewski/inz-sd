package servicedesk.scm.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import servicedesk.domain.Employee;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.slm.domain.Agreement;

@Entity
@Table(name="SERVICES")
public class Service implements DomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SERVICE_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SERVICE_TYPE_CODE")
	private ServiceType type;
	
	@Column(name="BUSINESS_IMPACT_CODE")
	private String impact;
	
	@Column(name="BUSINESS_PRIORITY_CODE")
	private String priority;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="AGREEMENT_ID")
	private Agreement agreement;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="SUPPORTING_SERVICES", joinColumns = { 
        @JoinColumn(name="SERVICE_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="SUPPORTING_SERVICE_ID", nullable=false, updatable=false) })
	private List<Service> supportingServices;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="SERVICE_MANAGERS", joinColumns = { 
        @JoinColumn(name="SERVICE_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="EMPLOYEE_ID", nullable=false, updatable=false) })
	private List<Employee> managers = new LinkedList<Employee>();

    @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

	public List<Service> getSupportingServices() {
		return supportingServices;
	}

	public void setSupportingServices(List<Service> supportingServices) {
		this.supportingServices = supportingServices;
	}

	public List<Employee> getManagers() {
		return managers;
	}

	public void setManagers(List<Employee> managers) {
		this.managers = managers;
	}
	
	
}
