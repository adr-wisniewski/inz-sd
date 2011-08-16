/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.common.notification.domain.Notification;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="RFC_NOTIFICATIONS")
public class RfcNotification extends Notification {

    private Rfc rfc;
    private Type type;
    
    protected RfcNotification() {
    }
    
    public RfcNotification(User owner, User instigator, Rfc rfc, Type type) {
        super(owner, instigator);
        this.rfc = rfc;
        this.type = type;
    }

    /**
     * @return the rfc
     */
    @ManyToOne(targetEntity=RfcImpl.class)
    @JoinColumn(name="RFC_ID", updatable=false)
    @Immutable
    public Rfc getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    protected void setRfc(Rfc rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the type
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name="TYPE")
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    protected void setType(Type type) {
        this.type = type;
    }

    @Override
    public <R, C> R accept(Notification.Visitor<R, C> visitor, C context) {
        if( visitor instanceof Visitor ) {
            Visitor<R,C> v = (Visitor<R,C>)visitor;
            return type.accept(v, context, this);
        }

        return null;
    }
    
    public static interface Visitor<ReturnType, Context> extends Notification.Visitor<ReturnType, Context>  {
        public ReturnType visitRfcUpdated(Context context, RfcNotification visited);
        public ReturnType visitRfcAddedComment(Context context, RfcNotification visited);
        public ReturnType visitRfcAssigned(Context context, RfcNotification visited);
        public ReturnType visitRfcUnassigned(Context context, RfcNotification visited);
        public ReturnType visitRfcReviewed(Context context, RfcNotification visited);
        public ReturnType visitRfcAppealed(Context context, RfcNotification visited);
        public ReturnType visitRfcReopened(Context context, RfcNotification visited);
        public ReturnType visitRfcRejected(Context context, RfcNotification visited);
        public ReturnType visitRfcClosed(Context context, RfcNotification visited);
        public ReturnType visitRfcBuilt(Context context, RfcNotification visited);
        public ReturnType visitRfcScheduled(Context context, RfcNotification visited);
        public ReturnType visitRfcAuthorized(Context context, RfcNotification visited);
        public ReturnType visitRfcAssessed(Context context, RfcNotification visited);
    }
    
    public static enum Type {
        UPDATED {
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcUpdated(context, visited);
            }
        },
        
        ADDED_COMMENT {
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcAddedComment(context, visited);
            }
        }, ASSIGNED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcAssigned(context, visited);
            }
        }, UNASSIGNED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcUnassigned(context, visited);
            }
        }, REVIEWED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcReviewed(context, visited);
            }
        }, APPEALED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcAppealed(context, visited);
            }
        }, REOPENED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcReopened(context, visited);
            }
        }, REJECTED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcRejected(context, visited);
            }
        }, CLOSED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcClosed(context, visited);
            }
        }, BUILT{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcBuilt(context, visited);
            }
        }, SCHEDULED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcScheduled(context, visited);
            }
        }, AUTHORIZED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcAuthorized(context, visited);
            }
        }, ASSESSED{
            @Override
            public <R, C> R accept(Visitor<R, C> visitor, C context, RfcNotification visited) {
                return visitor.visitRfcAssessed(context, visited);
            }
        };
        
        public abstract <R,C> R accept(Visitor<R,C> visitor, C context, RfcNotification visited);
    }
}
