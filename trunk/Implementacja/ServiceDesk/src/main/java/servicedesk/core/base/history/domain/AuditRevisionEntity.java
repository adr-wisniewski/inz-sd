/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.history.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import servicedesk.infrastructure.dao.hibernate.AuditRevisionListener;
import servicedesk.core.base.security.domain.User;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="AUDITREVISION")
@RevisionEntity(AuditRevisionListener.class)
public class AuditRevisionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Date timestamp;
    private User instigator;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "AUDITREVISION_SEQ", sequenceName = "AUDITREVISION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDITREVISION_SEQ")
    @RevisionNumber
    @Column(name="ID")
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the timestamp
     */
    @RevisionTimestamp
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="`TIMESTAMP`")
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the employee
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    public User getInstigator() {
        return instigator;
    }

    /**
     * @param employee the employee to set
     */
    public void setInstigator(User instigator) {
        this.instigator = instigator;
    }

 
}
