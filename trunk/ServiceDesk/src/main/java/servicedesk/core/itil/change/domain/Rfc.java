package servicedesk.core.itil.change.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Immutable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.infrastructure.interfaces.domain.PersistanceAwareDomainObject;

@Entity
@Table(name = "RFC")
public class Rfc implements DomainObject<Integer>, PersistanceAwareDomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    
    protected Employee author;
    protected Date timestamp;
    
    protected String title;
    protected String description;
    protected String comment;
    
    protected RfcState state = RfcState.NEW;
    protected Employee manager;
    protected RfcCategory category;
    protected RfcPriority priority;
    protected RfcImpact impact;
    protected RfcResolution resolution;
   
    protected Rfc() {
        // no arg ctor for hibernate
    }
    
    public Rfc(Employee author) {
        this.author = author;
    }
    
    
    @Id
    @SequenceGenerator(name = "RFC_SEQ", sequenceName = "RFC_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_SEQ")
    @Column(name="RFC_ID")
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    @Column(name="TITLE", length=2000, nullable=false)
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    @Audited
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    @Column(name="DESCRIPTION", length=4000, nullable=false)
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    @Audited
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priority
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRIORITY_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcPriority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(RfcPriority priority) {
        this.priority = priority;
    }

    /**
     * @return the impact
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IMPACT_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcImpact getImpact() {
        return impact;
    }

    /**
     * @param impact the impact to set
     */
    public void setImpact(RfcImpact impact) {
        this.impact = impact;
    }

    /**
     * @return the category
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(RfcCategory category) {
        this.category = category;
    }

    /**
     * @return the author
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CREATOR_ID", nullable=false, updatable=false)
    @Immutable
    public Employee getAuthor() {
        return author;
    }

    /**
     * @param author 
     */
    public void setAuthor(Employee author) {
        this.author = author;
    }

    /**
     * @return the creationTime
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="CREATIONTIME", nullable=false, updatable=false)
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp 
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the state
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`STATE`")
    @Audited
    public RfcState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(RfcState state) {
        this.state = state;
    }

    /**
     * @return the manager
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="MANAGER_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public Employee getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * @return the comment
     */
    @Lob
    @Column(name = "`COMMENT`")
    @Audited
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the resolution
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="RESOLUTION_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcResolution getResolution() {
        return resolution;
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(RfcResolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public void onPersist() {
        setTimestamp(new Date());
    }
}
