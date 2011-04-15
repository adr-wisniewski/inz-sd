/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Adrian
 */
@Embeddable
public class AttributeValuePk implements Serializable {
    private Entity entity;
    private Attribute attribute;

    /**
     * @return the entity
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID")
    public Entity getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * @return the attribute
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ATTRIBITE_ID")
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AttributeValuePk other = (AttributeValuePk) obj;
        if (this.entity != other.entity && (this.entity == null || !this.entity.equals(other.entity))) {
            return false;
        }
        if (this.attribute != other.attribute && (this.attribute == null || !this.attribute.equals(other.attribute))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.entity != null ? this.entity.hashCode() : 0);
        hash = 43 * hash + (this.attribute != null ? this.attribute.hashCode() : 0);
        return hash;
    }
}
