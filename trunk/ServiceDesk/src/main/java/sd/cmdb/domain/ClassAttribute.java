/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="C2_CLASS_ATTRIBUTES")
public class ClassAttribute implements Serializable {

    private ClassAttributePk id;
    private String name;
    private String description;
    private ElementClass elementClass;

    @Id
    public ClassAttributePk getId() {
        return id;
    }

    public void setId(ClassAttributePk id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 2000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASS_ID", insertable = false, updatable = false)
    public ElementClass getElementClass() {
        return elementClass;
    }

    public void setElementClass(ElementClass elementClass) {
        this.elementClass = elementClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ClassAttribute)) {
            return false;
        }
        final ClassAttribute other = (ClassAttribute) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}