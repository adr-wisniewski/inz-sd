package sd.im.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import sd.domain.Employee;
import sd.scm.domain.Service;

@Entity
@Table(name = "INCIDENTS_HISTORY")
@NamedQueries({
    @NamedQuery(name = "Incident.history", query = "SELECT h FROM IncidentHistory h WHERE h.incidentId = ? ORDER BY h.changeDate")})
public class IncidentHistory {
	@Id
	@Column(name = "HISTORY_ID")
	private Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;
    
	@Column(name = "CHANGE_DATE")
	private Date changeDate;
	
	@Column(name = "INCIDENT_ID")
	private Integer incidentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_CODE")
	private IncidentCategory category;

	@Column(name = "CLOSURE_DATE")
	private Date closureDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IMPACT_CODE")
	private IncidentImpact impact;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRIORITY_CODE")
	private IncidentPriority priority;

	@Column(name = "RESOLUTION")
	private String resolution;

	@Column(name = "RESOLUTION_DATE")
	private Date resolutionDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SOURCE_CODE")
	private IncidentSource source;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATUS_CODE", nullable = false)
	private IncidentStatus status;

	@Column(name = "SUBJECT")
	private String subject;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GROUP_ID")
	private SupportGroup supportGroup;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STAFF_MEMBER")
	private Employee supportGroupMember;

	@Column(name = "TARGET_RESOLUTION_DATE")
	private Date targetResolutionDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "URGENCY_CODE")
	private IncidentUrgency urgency;


        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "SERVICE_ID")
        private Service service;

        public Service getService() {
            return service;
        }

        public void setService(Service service) {
            this.service = service;
        }

        public IncidentCategory getCategory() {
		return category;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public IncidentImpact getImpact() {
		return impact;
	}

	public IncidentPriority getPriority() {
		return priority;
	}

	public String getResolution() {
		return resolution;
	}

	public Date getResolutionDate() {
		return resolutionDate;
	}

	public IncidentSource getSource() {
		return source;
	}

	public IncidentStatus getStatus() {
		return status;
	}

	public String getSubject() {
		return subject;
	}

	public SupportGroup getSupportGroup() {
		return supportGroup;
	}

	public Employee getSupportGroupMember() {
		return supportGroupMember;
	}

	public Date getTargetResolutionDate() {
		return targetResolutionDate;
	}

	public IncidentUrgency getUrgency() {
		return urgency;
	}

	public void setCategory(IncidentCategory category) {
		this.category = category;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImpact(IncidentImpact impact) {
		this.impact = impact;
	}

	public void setPriority(IncidentPriority priority) {
		this.priority = priority;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public void setSource(IncidentSource source) {
		this.source = source;
	}

	public void setStatus(IncidentStatus status) {
		this.status = status;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSupportGroup(SupportGroup supportGroup) {
		this.supportGroup = supportGroup;
	}

	public void setSupportGroupMember(Employee supportGroupMember) {
		this.supportGroupMember = supportGroupMember;
	}

	public void setTargetResolutionDate(Date targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}

	public void setUrgency(IncidentUrgency urgency) {
		this.urgency = urgency;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Integer getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(Integer incidentId) {
		this.incidentId = incidentId;
	}
}
