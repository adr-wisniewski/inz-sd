/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.StringUtils;
import servicedesk.infrastructure.general.domain.VersionedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="C2_CLASSES")
@Inheritance(strategy=InheritanceType.JOINED)
abstract public class AbstractEntityClass implements EntityClass, VersionedDomainObject<Integer>, Serializable {
    protected Integer id;
    protected Integer version;
    protected String name;
    protected String description;
    protected boolean abstraction;
    protected List<Attribute> attributes = new LinkedList<Attribute>();

    @Id
    @SequenceGenerator(name = "C2_CLASS_SEQ", sequenceName = "C2_CLASS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_CLASS_SEQ")
    @Column(name = "CLASS_ID", precision = 10)
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

    @org.hibernate.annotations.Type(type="yes_no")
    @Column(name = "IS_ABSTRACT", length = 1)
    //@Audited
    @Override
    public boolean isAbstraction() {
        return abstraction;
    }

    public void setAbstraction(boolean abstraction) {
        this.abstraction = abstraction;
    }

    @Column(name = "NAME", length = 200)
    @NaturalId(mutable=true)
    //@Audited
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.capitalize(name);
    }

    @Column(name = "DESCRIPTION", length = 2000)
    //@Audited
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "entityClass", fetch = FetchType.LAZY, orphanRemoval=true)
    @OrderBy("displayNo ASC")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    //@Audited
    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Transient
    @Override
    public List<Attribute> getAllAttributesSorted() {
        List<Attribute> allAttributes = getAllAttributes();
        Collections.sort(allAttributes);
        return allAttributes;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntityClass)) {
            return false;
        }
        final AbstractEntityClass other = (AbstractEntityClass) obj;

        if ((getName() == null) ? (other.getName() != null) : !getName().equals(other.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (getName() != null ? getName().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("identifier", getId())
            .append("name", name)
            .append("abstraction", abstraction)
            .toString();
    }
}
