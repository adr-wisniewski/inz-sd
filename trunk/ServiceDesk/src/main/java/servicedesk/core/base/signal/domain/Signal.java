package servicedesk.core.base.signal.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Type;

import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.interfaces.domain.DomainObject;


@Entity
@Table(name="SIGNALS")
@NamedQueries({
    @NamedQuery(name = "Signal.email", query = "SELECT s FROM Signal s WHERE s.sent = false"),
    @NamedQuery(name = "Signal.findByEmployee", query = "SELECT s FROM Signal s WHERE s.receiver = ?")
})
public class Signal implements DomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="signal")
	private List<SignalAttribute> attributes = new LinkedList<SignalAttribute>();
	
	@Column(name="CREATION_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
	
	@Column(name="ERROR_MESSAGE")
	private String errorMessage;
	
	@Id
	@SequenceGenerator(name = "SIGNAL_ID_SEQ", sequenceName = "SIGNAL_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIGNAL_ID_SEQ")
	@Column(name="SIGNAL_ID")
	private Integer id;
	
	@Column(name="OBJECT_ID")
	private Integer objectId;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
	private Employee receiver;
	
	@Column(name="IS_SENT")
	@Type(type = "true_false")
	private boolean sent;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TYPE_CODE")
	private SignalType type;

	public void addAttribute(SignalAttribute sa) {
		this.attributes.add(sa);
	}

	public List<SignalAttribute> getAttributes() {
		return attributes;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public String getDetailsURL() {
		return type.getObjectType().getDetailsURL() + "?id=" + objectId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

    @Override
	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return mergeTemplateIntoString(type.getMessageTemplate());
	}

	public Integer getObjectId() {
		return objectId;
	}

	public Employee getReceiver() {
		return receiver;
	}

	public String getSubject() {
		return mergeTemplateIntoString(type.getSubjectTemplate());
	}

	public SignalType getType() {
		return type;
	}

	public boolean isSent() {
		return sent;
	}

	private String mergeTemplateIntoString(String template) {
		String result = template;
		
		for(SignalAttribute a : attributes) {
			String value = a.getValue() != null ? a.getValue() : "";
			result = result.replace("${" + a.getAttributeType().getName() + "}", value);

		}
		
		return result;
	}

	public void setAttributes(List<SignalAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	
	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}
	
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	
	public void setType(SignalType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Signal [creationDate=" + creationDate + ", id=" + id
				+ ", objectId=" + objectId + ", receiver=" + receiver
				+ ", sent=" + sent + ", type=" + type + "]";
	}
}
