/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_CLASS_ATTRIBUTE_VALUES")
public class AttributeValue implements Comparable<AttributeValue>, Serializable {

    private AttributeValuePk pk = new AttributeValuePk();
    private String value;

    @Id
    public AttributeValuePk getPk() {
        return pk;
    }

    public void setPk(AttributeValuePk pk) {
        this.pk = pk;
    }

    @Column(name = "`VALUE`", length = 2000)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

        @Transient
    public Entity getEntity() {
        return getPk().getEntity();
    }

    public void setEntity(Entity entity) {
        getPk().setEntity(entity);
    }

    @Transient
    public Attribute getAttribute() {
        return getPk().getAttribute();
    }

    public void setAttribute(Attribute attribute) {
        getPk().setAttribute(attribute);
    }

    @Override
    public int compareTo(AttributeValue o) {
        return getAttribute().compareTo(o.getAttribute());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AttributeValue other = (AttributeValue) obj;
        if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.pk != null ? this.pk.hashCode() : 0);
        return hash;
    }
}
