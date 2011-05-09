package servicedesk.change.domain;

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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.general.domain.CreationMarked;
import servicedesk.infrastructure.general.domain.DomainObject;

@Entity
@Table(name = "RFC")
public class Rfc implements DomainObject<Integer>, CreationMarked, Serializable {
    private Integer id;
    private RfcState state = RfcState.NEW;
    private Employee creator;
    private Date creationTimestamp;
    private String title;
    private String description;
    private Employee manager;
    private RfcPriority priority;
    private RfcImpact impact;
    
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
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priority
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRIORITY")
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
    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * @param creationTime the creationTime to set
     */
    @Override
    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * @return the state
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`STATE`")
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
    public Employee getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
