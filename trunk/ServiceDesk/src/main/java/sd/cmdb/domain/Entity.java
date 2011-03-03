/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import sd.infrastructure.domain.VersionedDomainObject;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ENTITIES")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Entity implements VersionedDomainObject<Integer>, Serializable {
    
    private Integer id;
    private Integer version;
    private List<AttributeValue> attributeValues;

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
    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ENTITY_ID")
    //@MapKey(name="attribute.name")
    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
