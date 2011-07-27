/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import servicedesk.infrastructure.interfaces.domain.VersionedDomainObject;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ENTITIES")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Entity implements VersionedDomainObject<Integer>, Serializable {
    
    protected Integer id;
    protected Integer version;
    protected List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "C2_ENTITIES_SEQ", sequenceName = "C2_ENTITIES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_ENTITIES_SEQ")
    @Column(name = "ENTITY_ID", precision = 10)
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the version
     */
    @Version
    @Column(name = "VERSION", precision = 10)
    @Override
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    protected void setVersion(Integer version) {
        this.version = version;
    }

    @Transient
    public abstract EntityClass getEntityClass();

    @OneToMany(mappedBy="pk.entity", cascade = CascadeType.ALL)
    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public AttributeValue getAttributeValue(Attribute attribute) {
        for(AttributeValue attributeValue: getAttributeValues()) {
            if(attributeValue.getAttribute().equals(attribute))
                return attributeValue;
        }

        // create this attribute value instance
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setAttribute(attribute);
        attributeValue.setEntity(this);
        attributeValue.setValue(null);
        getAttributeValues().add(attributeValue);
        return attributeValue;
    }

    @Transient
    public abstract String getOverview();

    // TODO2: at least make protected, best remove
    public void populateAttributeValues() {
        for(Attribute attribute: getEntityClass().getAllAttributes()) {
            getAttributeValue(attribute);
            Collections.sort(getAttributeValues());
        }
    }
}
