package servicedesk.core.itil.change.domain.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.annotations.Immutable;
import org.hibernate.classic.Lifecycle;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.itil.cmdb.domain.RfcItem;
import servicedesk.infrastructure.interfaces.domain.VersionedDomainObject;

@Entity
@Table(name = "RFC")
public class RfcImpl implements Rfc, VersionedDomainObject<Integer>, Lifecycle, Serializable {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    private Integer version;
    
    protected User author;
    protected Date timestamp;
    
    protected String title;
    protected String description;
    protected String pir;
    protected String comment;
    
    protected RfcState state = RfcState.NEW;
    protected Employee manager;
    protected Employee builder;
    protected RfcAuthority authority;
    protected RfcAuthority cab;
    protected RfcCategory category;
    protected RfcPriority priority;
    protected RfcImpact impact;
    protected RfcResolution resolution;
    
    private RfcItem rfcItem = new RfcItem(this);
    
   
    protected RfcImpl() {
        // no arg ctor for hibernate
    }
    
    public RfcImpl(User author) {
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
     * @return the version
     */
    @Version
    @Override
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the title
     */
    @Column(name="TITLE", length=2000, nullable=false)
    @Audited
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    @Column(name="DESCRIPTION", length=4000, nullable=false)
    @Audited
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priority
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRIORITY_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    @Override
    public RfcPriority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    @Override
    public void setPriority(RfcPriority priority) {
        this.priority = priority;
    }

    /**
     * @return the impact
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IMPACT_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    @Override
    public RfcImpact getImpact() {
        return impact;
    }

    /**
     * @param impact the impact to set
     */
    @Override
    public void setImpact(RfcImpact impact) {
        this.impact = impact;
    }

    /**
     * @return the category
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    @Override
    public RfcCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    @Override
    public void setCategory(RfcCategory category) {
        this.category = category;
    }

    /**
     * @return the author
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CREATOR_ID", nullable=false, updatable=false)
    @Immutable
    @Override
    public User getAuthor() {
        return author;
    }

    /**
     * @param author 
     */
    protected void setAuthor(User author) {
        this.author = author;
    }

    /**
     * @return the creationTime
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="CREATIONTIME", nullable=false, updatable=false)
    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp 
     */
    protected void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the state
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`STATE`")
    @Audited
    @Override
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
    @Override
    public Employee getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * @return the comment
     */
    @Lob
    @Column(name = "`COMMENT`")
    @Audited
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the resolution
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="RESOLUTION_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    @Override
    public RfcResolution getResolution() {
        return resolution;
    }

    /**
     * @param resolution the resolution to set
     */
    @Override
    public void setResolution(RfcResolution resolution) {
        this.resolution = resolution;
    }

    /**
     * @return the rfcItem
     */
    @OneToOne(mappedBy = "rfc", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @Override
    public RfcItem getRfcItem() {
        return rfcItem;
    }

    /**
     * @param rfcItem the rfcItem to set
     */
    protected void setRfcItem(RfcItem rfcItem) {
        this.rfcItem = rfcItem;
    }

    @Override
    public boolean onSave(Session s) throws CallbackException {
        setTimestamp(new Date());
        rfcItem.setLabel("RFC#" + this.getId());
        return false;
    }

    @Override
    public boolean onUpdate(Session s) throws CallbackException {
        return false;
    }

    @Override
    public boolean onDelete(Session s) throws CallbackException {
        return false;
    }

    @Override
    public void onLoad(Session s, Serializable id) {
        // empty
    }

    @Override
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="BUILDER_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public Employee getBuilder() {
        return builder;
    }

    @Override
    public void setBuilder(Employee employee) {
        this.builder = employee;
    }

    @Override
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="AUTHORITY_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcAuthority getAuthority() {
        return authority;
    }

    @Override
    public void setAuthority(RfcAuthority authority) {
        this.authority = authority;
    }

    @Override
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CAB_ID")
    @Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
    public RfcAuthority getCab() {
        return cab;
    }

    @Override
    public void setCab(RfcAuthority cab) {
        this.cab = cab;
    }

    @Column(name="PIR")
    @Lob
    @Audited
    @Override
    public String getPir() {
        return pir;
    }

    @Override
    public void setPir(String pir) {
        this.pir = pir;
    }
}
