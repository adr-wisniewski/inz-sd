package sd.rf.domain;

import java.util.Calendar;
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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sd.domain.Comment;
import sd.domain.Employee;
import sd.event.domain.IEvent;
import sd.im.domain.SupportGroup;

@Entity
@Table(name="REQUESTS")
public class ServiceRequest implements IEvent {
	@Id
	@SequenceGenerator(name = "request_seq", sequenceName = "event_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq")
	@Column(name = "REQUEST_ID")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORY_CODE")
	private RequestCategory category;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="request")
	@OrderBy("id")
	private List<RequestAttribute> attributes;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Column(name="CLOSURE_DATE")
	private Date closureDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="AUTHOR")
	private Employee author;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRIORITY_CODE")
	private RequestPriority priority;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STATUS_CODE")
	private RequestStatus status;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="request")
	@OrderBy("creationDate")
	private List<Comment> comments = new LinkedList<Comment>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequestCategory getCategory() {
		return category;
	}

	public void setCategory(RequestCategory category) {
		this.category = category;
	}

	public List<RequestAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<RequestAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	public RequestPriority getPriority() {
		return priority;
	}

	public void setPriority(RequestPriority priority) {
		this.priority = priority;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setRequest(this);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STAFF_MEMBER")
	private Employee supportGroupMember;

	public Employee getSupportGroupMember() {
		return supportGroupMember;
	}

	public void setSupportGroupMember(Employee supportGroupMember) {
		this.supportGroupMember = supportGroupMember;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_ID")
	private SupportGroup supportGroup;

	public SupportGroup getSupportGroup() {
		return supportGroup;
	}

	public void setSupportGroup(SupportGroup supportGroup) {
		this.supportGroup = supportGroup;
	}
	
	@Column(name = "TARGET_RESOLUTION_DATE")
	private Date targetResolutionDate;
	
	public Date getTargetResolutionDate() {
		return targetResolutionDate;
	}

	public void setTargetResolutionDate(Date targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}
	
	/**
	 * Uaktualnia termin rozwiazania requestu na podstawie priorytetu
	 */
	public void refreshTargetResolutionDate() {
		if(this.priority != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(creationDate);
			c.add(Calendar.HOUR, priority.getTargetResolutionTime());
			this.targetResolutionDate = c.getTime();
		}
	}
}
