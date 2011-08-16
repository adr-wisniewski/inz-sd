/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.common.notification.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import org.hibernate.classic.Lifecycle;
import servicedesk.core.base.security.domain.Ownable;
import servicedesk.core.base.security.domain.User;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="NOTIFICATIONS")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(
    @NamedQuery(name="Notification.forUser", query="from Notification as n where n.owner = :user order by n.timestamp desc")
)
public abstract class Notification implements DomainObject<Integer>, Ownable, Lifecycle, Serializable {
    private Integer id;
    private User owner;
    private boolean visited;
    private Date timestamp;
    private User instigator;

    /**
     * for hibernate
     */
    protected Notification() {
        // empty
    }
    
    public Notification(User owner, User instigator) {
        this.owner = owner;
        this.instigator = instigator;
    }
    
    /**
     * @return the id
     */
    @Id
    @Column(name="NOTIFICATION_ID", length = 10)
    @SequenceGenerator(name = "NOTIFICATIONS_SEQ", sequenceName = "NOTIFICATIONS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATIONS_SEQ")
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    protected void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    @ManyToOne
    @JoinColumn(name="USER_ID", updatable=false)
    @Immutable
    @Override
    public User getOwner() {
        return owner;
    }

    /**
     * @param user the user to set
     */
    protected void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * @return the visited
     */
    @Type(type="yes_no")
    @Column(name="VISITED")
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the timestamp
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="`TIMESTAMP`", updatable=false)
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    protected void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the instigator
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="INSTIGATOR_ID", updatable=false)
    @Immutable
    public User getInstigator() {
        return instigator;
    }

    /**
     * @param instigator the instigator to set
     */
    protected void setInstigator(User instigator) {
        this.instigator = instigator;
    }


    @Override
    public boolean onSave(Session s) throws CallbackException {
        setTimestamp(new Date());
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
    
    public abstract <R,C> R accept(Visitor<R,C> visitor, C context);
    
    public static interface Visitor<ReturnType,ContextType> {
        
    }
}
