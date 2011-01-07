/**
 * 
 */
package sd.im.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sd.domain.Comment;
import sd.domain.Employee;
import sd.em.domain.Event;
import sd.event.domain.IEvent;
import sd.scm.domain.Service;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "INCIDENTS")
@NamedQueries({
    @NamedQuery(name = "Incident.findById", query = "SELECT i FROM Incident i WHERE i.id = ?")})
public class Incident implements IEvent {

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @SequenceGenerator(name = "incident_seq", sequenceName = "event_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incident_seq")
    @Column(name = "INCIDENT_ID")
    private Integer id;

    /* (non-Javadoc)
     * @see sd.im.domain.Event#getId()
     */
    public Integer getId() {
        // begin-user-code
        return id;
        // end-user-code
    }

    /* (non-Javadoc)
     * @see sd.im.domain.Event#setId(java.lang.Integer)
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
    @Column(name = "RESOLUTION")
    private String resolution;

    /**
     * /**
     *  * @return the resolution
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getResolution() {
        // begin-user-code
        return resolution;
        // end-user-code
    }

    /**
     * /**
     *  * @param resolution the resolution to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setResolution(String resolution) {
        // begin-user-code
        this.resolution = resolution;
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

    /* (non-Javadoc)
     * @see sd.im.domain.Event#setCreationDate(java.util.Date)
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRIORITY_CODE")
    private IncidentPriority priority;

    /**
     * /**
     *  * @return the priority
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentPriority getPriority() {
        // begin-user-code
        return priority;
        // end-user-code
    }

    /**
     * /**
     *  * @param priority the priority to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPriority(IncidentPriority priority) {
        // begin-user-code
        this.priority = priority;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_CODE")
    private IncidentCategory category;

    /**
     * /**
     *  * @return the category
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentCategory getCategory() {
        // begin-user-code
        return category;
        // end-user-code
    }

    /**
     * /**
     *  * @param category the category to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setCategory(IncidentCategory category) {
        // begin-user-code
        this.category = category;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_CODE", nullable = false)
    private IncidentStatus status;

    /**
     * /**
     *  * @return the status
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentStatus getStatus() {
        // begin-user-code
        return status;
        // end-user-code
    }

    /**
     * /**
     *  * @param status the status to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setStatus(IncidentStatus status) {
        // begin-user-code
        this.status = status;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR")
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
    @Column(name = "RESOLUTION_DATE")
    private Date resolutionDate;

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "incident")
    @OrderBy("creationDate")
    private List<Comment> comments = new LinkedList<Comment>();

    /* (non-Javadoc)
     * @see sd.im.domain.Event#getComments()
     */
    public List<Comment> getComments() {
        // begin-user-code
        return comments;
        // end-user-code
    }

    /* (non-Javadoc)
     * @see sd.im.domain.Event#setComments(java.util.Set)
     */
    public void setComments(List<Comment> comments) {
        // begin-user-code
        this.comments = comments;
        // end-user-code
    }

    /*
    private HistoryAction history;

    public HistoryAction getHistory() {
    // begin-user-code
    return history;
    // end-user-code
    }

    public void setHistory(HistoryAction history) {
    // begin-user-code
    this.history = history;
    // end-user-code
    }
     */
    /* (non-Javadoc)
     * @see sd.im.domain.Event#addComment(sd.domain.Comment)
     */
    public void addComment(Comment comment) {
        comment.setIncident(this);
        comments.add(comment);
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IMPACT_CODE")
    private IncidentImpact impact;

    /**
     * /**
     *  * @return the impact
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentImpact getImpact() {
        // begin-user-code
        return impact;
        // end-user-code
    }

    /**
     * /**
     *  * @param impact the impact to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setImpact(IncidentImpact impact) {
        // begin-user-code
        this.impact = impact;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "URGENCY_CODE")
    private IncidentUrgency urgency;

    /**
     * /**
     *  * @return the urgency
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentUrgency getUrgency() {
        // begin-user-code
        return urgency;
        // end-user-code
    }

    /**
     * /**
     *  * @param urgency the urgency to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setUrgency(IncidentUrgency urgency) {
        // begin-user-code
        this.urgency = urgency;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SOURCE_CODE")
    private IncidentSource source;

    /**
     * /**
     *  * @return the source
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public IncidentSource getSource() {
        // begin-user-code
        return source;
        // end-user-code
    }

    /**
     * /**
     *  * @param source the source to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSource(IncidentSource source) {
        // begin-user-code
        this.source = source;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "CLOSURE_DATE")
    private Date closureDate;

    /**
     * /**
     *  * @return the closureDate
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getClosureDate() {
        // begin-user-code
        return closureDate;
        // end-user-code
    }

    /**
     * /**
     *  * @param closureDate the closureDate to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setClosureDate(Date closureDate) {
        // begin-user-code
        this.closureDate = closureDate;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STAFF_MEMBER")
    private Employee supportGroupMember;

    /**
     * /**
     *  * @return the supportGroupMember
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Employee getSupportGroupMember() {
        // begin-user-code
        return supportGroupMember;
        // end-user-code
    }

    /**
     * /**
     *  * @param supportGroupMember the supportGroupMember to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSupportGroupMember(Employee supportGroupMember) {
        // begin-user-code
        this.supportGroupMember = supportGroupMember;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GROUP_ID")
    private SupportGroup supportGroup;

    /**
     * /**
     *  * @return the supportGroup
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public SupportGroup getSupportGroup() {
        // begin-user-code
        return supportGroup;
        // end-user-code
    }

    /**
     * /**
     *  * @param supportGroup the supportGroup to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSupportGroup(SupportGroup supportGroup) {
        // begin-user-code
        this.supportGroup = supportGroup;
        // end-user-code
    }
    @Column(name = "TARGET_RESOLUTION_DATE")
    private Date targetResolutionDate;

    public Date getTargetResolutionDate() {
        return targetResolutionDate;
    }

    public void setTargetResolutionDate(Date targetResolutionDate) {
        this.targetResolutionDate = targetResolutionDate;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "incident")
    private List<Event> events = new LinkedList<Event>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LAST_EDIT_BY")
    private Employee lastEditBy;

    public Employee getLastEditBy() {
        return lastEditBy;
    }

    public void setLastEditBy(Employee lastEditBy) {
        this.lastEditBy = lastEditBy;
    }

    /**
     * Uaktualnia termin rozwiazania incydentu na podstawie priorytetu
     */
    public void refreshTargetResolutionDate() {
        if (this.service != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(creationDate);
//			c.add(Calendar.HOUR, priority.getTargetResolutionTime());
            c.add(Calendar.HOUR, service.getAgreement().getResolutionTime());
            this.targetResolutionDate = c.getTime();
        }
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Incident other = (Incident) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Incident [author=" + author + ", category=" + category
                + ", closureDate=" + closureDate + ", comments=" + comments
                + ", creationDate=" + creationDate + ", description="
                + description + ", id=" + id + ", impact=" + impact
                + ", priority=" + priority + ", resolution=" + resolution
                + ", source=" + source + ", status=" + status + ", subject="
                + subject + ", supportGroupMember=" + supportGroupMember
                + ", urgency=" + urgency + "]";
    }
}
