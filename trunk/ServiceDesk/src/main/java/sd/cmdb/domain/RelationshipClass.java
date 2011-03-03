/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import sd.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="C2_RELATION_CLASSES")
@PrimaryKeyJoinColumn(name = "CLASS_ID")
public class RelationshipClass extends AbstractEntityClass {
    protected RelationshipClass parent;
    protected Set<RelationshipClass> children;
    protected Quantity quantity;
    protected String label;
    protected String reverseLabel;
    protected ItemType sourceType;
    protected ItemType targetType;
    protected UniversalItemClass sourceUniversalItemClass;
    protected UniversalItemClass targetUniversalItemClass;

    /**
     * @return the parent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CLASS_ID")
    @Override
    public RelationshipClass getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(RelationshipClass parent) {
        this.parent = parent;
    }

    @Override
    @Transient
    public Integer getParentId() {
        return parent.getId();
    }

    /**
     * @return the children
     */
    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY)
    @Cascade(value = {CascadeType.DELETE_ORPHAN})
    @Override
    public Set<RelationshipClass> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<RelationshipClass> children) {
        this.children = children;
    }

    /**
     * @return the quantity
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "QUANTITY", length = 1)
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @Transient
    public boolean isBidirectional()
    {
        return getReverseLabel() != null;
    }

    /**
     * @return the label
     */
    @Column(name = "LABEL", length = 200)
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the reverseLabel
     */
    @Column(name = "LABEL_REVERSE", length = 200)
    public String getReverseLabel() {
        return reverseLabel;
    }

    /**
     * @param reverseLabel the reverseLabel to set
     */
    public void setReverseLabel(String reverseLabel) {
        this.reverseLabel = reverseLabel;
    }

    /**
     * @return the sourceType
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "SOURCE_TYPE", length = 3)
    public ItemType getSourceType() {
        return sourceType;
    }

    /**
     * @param sourceType the sourceType to set
     */
    public void setSourceType(ItemType sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * @return the targetType
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "TARGET_TYPE", length = 3)
    public ItemType getTargetType() {
        return targetType;
    }

    /**
     * @param targetType the targetType to set
     */
    public void setTargetType(ItemType targetType) {
        this.targetType = targetType;
    }

    /**
     * @return the sourceItemClass
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SOURCE_CLASS_ID")
    public UniversalItemClass getSourceItemClass() {
        return sourceUniversalItemClass;
    }

    /**
     * @param sourceItemClass the sourceItemClass to set
     */
    public void setSourceItemClass(UniversalItemClass sourceClass) {
        this.sourceUniversalItemClass = sourceClass;
    }

    /**
     * @return the targetItemClass
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TARGET_CLASS_ID")
    public UniversalItemClass getTargetItemClass() {
        return targetUniversalItemClass;
    }

    /**
     * @param targetItemClass the targetItemClass to set
     */
    public void setTargetItemClass(UniversalItemClass targetClass) {
        this.targetUniversalItemClass = targetClass;
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

    @Override
    public void accept(EntityClassVisitor visitor) {
        visitor.visit(this);
    }
}
