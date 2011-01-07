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

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="C2_RELATION_CLASSES")
@PrimaryKeyJoinColumn(name = "CLASS_ID")
public class RelationshipClass extends ElementClass {
    protected RelationshipClass parent;
    protected Set<RelationshipClass> children;
    protected Quantity quantity;
    protected String label;
    protected String reverseLabel;
    protected ItemType sourceType;
    protected ItemType targetType;
    protected ItemClass sourceClass;
    protected ItemClass targetClass;

    /**
     * @return the parent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CLASS_ID")
    public RelationshipClass getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(RelationshipClass parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY)
    @Cascade(value = {CascadeType.DELETE_ORPHAN})
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
     * @return the sourceClass
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SOURCE_CLASS_ID")
    public ItemClass getSourceClass() {
        return sourceClass;
    }

    /**
     * @param sourceClass the sourceClass to set
     */
    public void setSourceClass(ItemClass sourceClass) {
        this.sourceClass = sourceClass;
    }

    /**
     * @return the targetClass
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TARGET_CLASS_ID")
    public ItemClass getTargetClass() {
        return targetClass;
    }

    /**
     * @param targetClass the targetClass to set
     */
    public void setTargetClass(ItemClass targetClass) {
        this.targetClass = targetClass;
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
