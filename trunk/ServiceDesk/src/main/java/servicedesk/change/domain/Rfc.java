package servicedesk.change.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.general.domain.CreationAutomaticallyMarked;
import servicedesk.infrastructure.general.domain.DomainObject;

@Entity
@Table(name = "RFC")
public class Rfc implements DomainObject<Integer>, CreationAutomaticallyMarked, Serializable {
    private Integer id;
    private RfcState state = RfcState.NEW;
    private Employee creator;
    private Date timestamp;
    private String title;
    private String description;
    private Employee manager;
    private RfcPriority priority;
    private RfcImpact impact;
    private List<RfcComment> comments = new LinkedList<RfcComment>();
    
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
    @JoinColumn(name="PRIORITY")
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
    @JoinColumn(name="IMPACT")
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
     * @return the author
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CREATOR", nullable=false)
    @Override
    public Employee getCreator() {
        return creator;
    }

    /**
     * @param author the author to set
     */
    @Override
    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    /**
     * @return the creationTime
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="CREATIONTIME", nullable=false)
    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param creationTime the creationTime to set
     */
    @Override
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
    @JoinColumn(name="MANAGER")
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
     * @return the comments
     */
    @OneToMany(mappedBy="id.rfc", cascade = CascadeType.ALL)
    public List<RfcComment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<RfcComment> comments) {
        this.comments = comments;
    }
    
}
