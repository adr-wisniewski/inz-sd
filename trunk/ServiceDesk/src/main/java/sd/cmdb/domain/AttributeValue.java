/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_CLASS_ATTRIBUTE_VALUES")
public class AttributeValue implements Serializable {

    private Entity entity;
    private Attribute attribute;
    private Integer version;
    private String value;
    /**
     * @return the entity
     */
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ENTITY_ID", insertable=false, updatable=false)
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
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ATTRIBITE_ID")
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     * @return the version
     */
    @Version
    @Column(name = "VERSION", precision = 10)
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
     * @return the value
     */
    @Column(name = "VALUE", length = 2000)
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
