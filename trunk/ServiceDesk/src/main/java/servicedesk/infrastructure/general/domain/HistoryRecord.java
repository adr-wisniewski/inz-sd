/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.domain;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.envers.RevisionType;

/**
 *
 * @author Adrian
 */
public class HistoryRecord<Type extends DomainObject<? extends Serializable>> {
    private Type object;
    private AuditRevisionEntity revison;
    private RevisionType revisonType;

    public HistoryRecord() {
        
    }
    
    /**
     * @return the object
     */
    public Type getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Type object) {
        this.object = object;
    }

    /**
     * @return the revison
     */
    public AuditRevisionEntity getRevison() {
        return revison;
    }

    /**
     * @param revison the revison to set
     */
    public void setRevison(AuditRevisionEntity revison) {
        this.revison = revison;
    }

    /**
     * @return the revisonType
     */
    public RevisionType getRevisonType() {
        return revisonType;
    }

    /**
     * @param revisonType the revisonType to set
     */
    public void setRevisonType(RevisionType revisonType) {
        this.revisonType = revisonType;
    }
}
