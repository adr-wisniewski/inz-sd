package servicedesk.em.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import servicedesk.im.domain.Incident;
import servicedesk.infrastructure.general.domain.DomainObject;

@Entity
@Table(name="EVENTS")
public class Event implements DomainObject<Integer>, Serializable{
    private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "event_seq", sequenceName = "event_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
        @Column(name = "EVENT_ID")
	private Integer id;
	
	@Column(name = "CREATION_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
	
	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "EVENT_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date eventDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="CATEGORY_CODE")
	private EventCategory category;
	
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="SIGNIFICANCE_CODE")
	private EventSignificance significance;
	
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="INCIDENT_ID")
	private Incident incident; 
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="event")
	private List<EventParameter> parameters = new LinkedList<EventParameter>();
	
        @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public EventSignificance getSignificance() {
		return significance;
	}
 
	public void setSignificance(EventSignificance significance) { 
		this.significance = significance;
	}
	
	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
	}
	
	public List<EventParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<EventParameter> parameters) {
		this.parameters = parameters;
	}
	
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [creationDate=" + creationDate + ", eventDate="
				+ eventDate + ", id=" + id + ", subject=" + subject + ", significane="
				+ significance + ", category=" + category + "]";
	}

	public void addParameter(EventParameter parameter) {
		parameters.add(parameter);
		parameter.setEvent(this);
	}
}
