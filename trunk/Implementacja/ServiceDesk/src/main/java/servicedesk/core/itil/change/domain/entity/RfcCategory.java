/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "RFC_CATEGORIES")
public class RfcCategory implements HierarchicalDomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private RfcCategory parent;
    private boolean abstraction;
    private String name;
    private List<RfcCategory> children = new ArrayList<RfcCategory>(0);
    private List<RfcAuthority> authorities = new ArrayList<RfcAuthority>(0);

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "RFC_CATEGORIES_SEQ", sequenceName = "RFC_CATEGORIES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_CATEGORIES_SEQ")
    @Column(name="CATEGORY_ID")
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
     * @return the parent
     */
    @ManyToOne
    @JoinColumn(name="PARENT_CATEGORY_ID")
    @Override
    public RfcCategory getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(RfcCategory parent) {
        this.parent = parent;
    }

    /**
     * @return the abstraction
     */
    @org.hibernate.annotations.Type(type="yes_no")
    @Column(name = "ABSTRACT", length = 1)
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
    @Column(name="NAME", length=200)
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "parent")
    @Override
    public List<RfcCategory> getChildren() {
        return children;
    }

    public void setChildren(List<RfcCategory> children) {
        this.children = children;
    }

    @ManyToMany(mappedBy = "categories")
    public List<RfcAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<RfcAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RfcCategory)) {
            return false;
        }
        final RfcCategory other = (RfcCategory) obj;
        if ((this.getId() == null) ? (other.getId() != null) : !this.getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    
    
    
}
