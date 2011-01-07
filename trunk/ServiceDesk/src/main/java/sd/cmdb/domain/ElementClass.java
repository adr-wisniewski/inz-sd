/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.io.Serializable;
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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.StringUtils;
import sd.infrastructure.domain.AbstractVersionedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity @Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="C2_CLASSES")
@Inheritance(strategy=InheritanceType.JOINED)
abstract public class ElementClass extends AbstractVersionedDomainObject<Integer> implements Serializable {

    protected String name;
    protected String description;
    protected boolean abstraction;
    protected List<ClassAttribute> attributes = new LinkedList<ClassAttribute>();

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "C2_CLASS_SEQ", sequenceName = "C2_CLASS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_CLASS_SEQ")
    @Column(name = "CLASS_ID", precision = 10)
    @Override
    public Integer getId() {
        return super.getId();
    }

    /**
     * @return the abstraction
     */
    @org.hibernate.annotations.Type(type="yes_no")
    @Column(name = "IS_ABSTRACT", length = 1)
    @Audited
    public boolean isAbstraction() {
        return abstraction;
    }

    /**
     * @param abstraction the abstraction to set
     */
    public void setAbstraction(boolean abstraction) {
        this.abstraction = abstraction;
    }

    /**
     * @return the name
     */
    @Column(name = "NAME", length = 200)
    @NaturalId
    @Audited
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = StringUtils.capitalize(name);
    }

    /**
     * @return the description
     */
    @Column(name = "DESCRIPTION", length = 2000)
    @Audited
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the attributes
     */
    @OneToMany(mappedBy = "elementClass", fetch = FetchType.LAZY, orphanRemoval=true)
    @OrderBy("id.attributeNo ASC")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public List<ClassAttribute> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<ClassAttribute> attributes) {
        this.attributes = attributes;
    }

    @Transient
    abstract public List<ClassAttribute> getInheritedAttributes();

    @Transient
    abstract public List<ClassAttribute> getAllAttributes();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ElementClass)) {
            return false;
        }
        final ElementClass other = (ElementClass) obj;

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
