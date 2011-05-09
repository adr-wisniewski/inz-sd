/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import java.io.Serializable;
import javax.persistence.Cacheable;
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
import javax.persistence.Version;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import servicedesk.infrastructure.general.domain.VersionedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="C2_CLASS_ATTRIBUTES")
public class Attribute implements VersionedDomainObject<Integer>, Comparable<Attribute>, Serializable {

    private Integer id;
    private Integer version;

    private EntityClass entityClass;
    
    private String name;
    private String description;
    private Integer displayNo;
    private boolean overview;

    @Id
    @SequenceGenerator(name = "C2_CLASS_ATTRIBUTES_SEQ", sequenceName = "C2_CLASS_ATTRIBUTES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_CLASS_ATTRIBUTES_SEQ")
    @Column(name = "ATTRIBUTE_ID", precision = 10)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION", precision = 10)
    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JoinColumn(name="CLASS_ID")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity=AbstractEntityClass.class)
    public EntityClass getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(EntityClass entityClass) {
        this.entityClass = entityClass;
    }

    @Column(name = "NAME", length = 200)
    //@Audited
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 2000)
    //@Audited
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "DISPLAY_NO", precision = 10)
    public Integer getDisplayNo() {
        return displayNo;
    }

    public void setDisplayNo(Integer displayNo) {
        this.displayNo = displayNo;
    }

    /**
     * @return the overview
     */
    @org.hibernate.annotations.Type(type="yes_no")
    @Column(name = "IS_OVERVIEW", length = 1)
    public boolean isOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(boolean overview) {
        this.overview = overview;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attribute other = (Attribute) obj;
        if (this.entityClass != other.entityClass && (this.entityClass == null || !this.entityClass.equals(other.entityClass))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.entityClass != null ? this.entityClass.hashCode() : 0);
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(Attribute o) {
        return getDisplayNo() - o.getDisplayNo();
    }
}