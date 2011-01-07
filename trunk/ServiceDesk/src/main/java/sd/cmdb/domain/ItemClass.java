/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import sd.tree.HierarchyItem;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="C2_ITEM_CLASSES")
@PrimaryKeyJoinColumn(name = "CLASS_ID")
@NamedQueries(
    @NamedQuery(name="ItemClass.findByName", query="from ItemClass as clazz where clazz.name = :name")
)
public class ItemClass extends ElementClass implements HierarchyItem {
    
    protected ItemClass parent;
    protected Set<ItemClass> children = new HashSet<ItemClass>();

    /**
     * @return the parent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CLASS_ID")
    public ItemClass getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(ItemClass parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY)
    public Set<ItemClass> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<ItemClass> children) {
        this.children = children;
    }

    @Override
    @Transient
    public String getId() {
        return getIdentifier() != null ? getIdentifier().toString() : null;
    }

    @Override
    @Transient
    public String getParentId() {
        return getParent() == null ? null : getParent().getId();
    }

    @Override
    @Transient
    public List<ClassAttribute> getInheritedAttributes() {
        if(getParent() == null)
            return new LinkedList<ClassAttribute>();

        return getParent().getAllAttributes();
    }

    @Override
    @Transient
    public List<ClassAttribute> getAllAttributes() {
        List<ClassAttribute> allAttributes = new LinkedList<ClassAttribute>();
        allAttributes.addAll(getAttributes());

        if(getParent() != null)
            allAttributes.addAll(getParent().getAllAttributes());

        return allAttributes;
    }
}
