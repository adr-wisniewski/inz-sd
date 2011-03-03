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
import sd.cmdb.domain.helper.EntityClassVisitor;
import sd.cmdb.domain.helper.ItemClassVisitor;
import sd.infrastructure.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
@Entity 
@Table(name="C2_ITEM_CLASSES")
@PrimaryKeyJoinColumn(name = "CLASS_ID")
@NamedQueries(
    @NamedQuery(name="UniversalItemClass.findByName", query="from UniversalItemClass as clazz where clazz.name = :name")
)
public class UniversalItemClass extends AbstractEntityClass implements ItemClass, HierarchicalDomainObject<Integer> {

    protected UniversalItemClass parent;
    protected Set<UniversalItemClass> children = new HashSet<UniversalItemClass>();
    protected List<UniversalItem> items;

    /**
     * @return the parent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CLASS_ID")
    //@Audited
    @Override
    public UniversalItemClass getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(UniversalItemClass parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY)
    @Override
    public Set<UniversalItemClass> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<UniversalItemClass> children) {
        this.children = children;
    }

    @Override
    @Transient
    public Integer getParentId() {
        return getParent() == null ? null : getParent().getId();
    }

    @Override
    @Transient
    public List<Attribute> getInheritedAttributes() {
        if(getParent() == null)
            return new LinkedList<Attribute>();

        return getParent().getAllAttributes();
    }

    @Override
    @Transient
    public List<Attribute> getAllAttributes() {
        List<Attribute> allAttributes = new LinkedList<Attribute>();
        allAttributes.addAll(getAttributes());

        if(getParent() != null)
            allAttributes.addAll(getParent().getAllAttributes());

        return allAttributes;
    }

    @OneToMany(mappedBy = "itemClass")
    public List<UniversalItem> getItems() {
        return items;
    }

    public void setItems(List<UniversalItem> items) {
        this.items = items;
    }

    @Override
    public void accept(EntityClassVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
