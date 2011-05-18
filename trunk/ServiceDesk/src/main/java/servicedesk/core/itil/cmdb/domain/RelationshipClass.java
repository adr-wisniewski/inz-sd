/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.cmdb.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassVisitor;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "C2_RELATION_CLASSES")
@PrimaryKeyJoinColumn(name = "CLASS_ID")
@NamedQueries({
    @NamedQuery(name = "RelationshipClass.findByName", query = "from RelationshipClass as clazz where clazz.name = :name"),
    @NamedQuery(name = "RelationshipClass.findForUniversalClass_source", query = "from RelationshipClass as clazz where clazz.abstraction = false and clazz.sourceUniversalItemClass in (:parentChain)"),
    @NamedQuery(name = "RelationshipClass.findForUniversalClass_target", query = "from RelationshipClass as clazz where clazz.abstraction = false and clazz.targetUniversalItemClass in (:parentChain)"),
    @NamedQuery(name = "RelationshipClass.findForType_source", query = "from RelationshipClass as clazz where clazz.abstraction = false and clazz.sourceType = :type"),
    @NamedQuery(name = "RelationshipClass.findForType_target", query = "from RelationshipClass as clazz where clazz.abstraction = false and clazz.targetType = :type")
})
public class RelationshipClass extends AbstractEntityClass {

    private static final long serialVersionUID = 1L;
    protected RelationshipClass parent;
    protected Set<RelationshipClass> children;
    protected List<Relationship> instances;
    protected String label;
    protected String reverseLabel;
    protected ItemType sourceType;
    protected ItemType targetType;
    protected UniversalItemClass sourceUniversalItemClass;
    protected UniversalItemClass targetUniversalItemClass;
    protected ItemClass sourceItemClass;
    protected ItemClass targetItemClass;

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

    /**
     * @return the children
     */
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
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

    @OneToMany(mappedBy = "relationshipClass", fetch = FetchType.LAZY)
    public List<Relationship> getInstances() {
        return instances;
    }

    public void setInstances(List<Relationship> instances) {
        this.instances = instances;
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
    public UniversalItemClass getSourceUniversalItemClass() {
        return sourceUniversalItemClass;
    }

    /**
     * @param sourceClass 
     */
    public void setSourceUniversalItemClass(UniversalItemClass sourceClass) {
        this.sourceUniversalItemClass = sourceClass;
    }

    /**
     * @return the targetItemClass
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TARGET_CLASS_ID")
    public UniversalItemClass getTargetUniversalItemClass() {
        return targetUniversalItemClass;
    }

    /**
     * @param targetClass 
     */
    public void setTargetUniversalItemClass(UniversalItemClass targetClass) {
        this.targetUniversalItemClass = targetClass;
    }

    /**
     * @return the sourceItemClass
     */
    @Transient
    public ItemClass getSourceItemClass() {
        return sourceItemClass;
    }

    /**
     * @param sourceItemClass the sourceItemClass to set
     */
    public void setSourceItemClass(ItemClass sourceItemClass) {
        ItemTypeResolver resolver = new ItemTypeResolver();
        sourceItemClass.accept(resolver);
        setSourceType(resolver.getItemType());
        setSourceUniversalItemClass(resolver.getUniversalItemClass());

        this.sourceItemClass = sourceItemClass;
    }

    public void setSourceItemClassDirect(ItemClass sourceItemClass) {
        this.sourceItemClass = sourceItemClass;
    }

    /**
     * @return the targetItemClass
     */
    @Transient
    public ItemClass getTargetItemClass() {
        return targetItemClass;
    }

    /**
     * @param targetItemClass the targetItemClass to set
     */
    public void setTargetItemClass(ItemClass targetItemClass) {
        ItemTypeResolver resolver = new ItemTypeResolver();
        targetItemClass.accept(resolver);
        setTargetType(resolver.getItemType());
        setTargetUniversalItemClass(resolver.getUniversalItemClass());

        this.targetItemClass = targetItemClass;
    }

    public void setTargetItemClassDirect(ItemClass targetItemClass) {
        this.targetItemClass = targetItemClass;
    }

    @Override
    @Transient
    public List<Attribute> getInheritedAttributes() {
        if (getParent() == null) {
            return new LinkedList<Attribute>();
        }

        return getParent().getAllAttributes();
    }

    @Override
    @Transient
    public List<Attribute> getAllAttributes() {
        List<Attribute> allAttributes = new LinkedList<Attribute>();
        allAttributes.addAll(getAttributes());

        if (getParent() != null) {
            allAttributes.addAll(getParent().getAllAttributes());
        }

        return allAttributes;
    }

    @Override
    public void accept(EntityClassVisitor visitor) {
        visitor.visit(this);
    }

    protected static class ItemTypeResolver implements ItemClassVisitor {

        private ItemType itemType;
        private UniversalItemClass universalItemClass = null;

        public ItemType getItemType() {
            return itemType;
        }

        public UniversalItemClass getUniversalItemClass() {
            return universalItemClass;
        }

        @Override
        public void visit(UniversalItemClass universalItemClass) {
            itemType = ItemType.UNI;
            this.universalItemClass = universalItemClass;
        }

        @Override
        public void visit(EmployeeItemClass employeeItemClass) {
            itemType = ItemType.EMP;
        }

        @Override
        public void visit(IncidentItemClass incidentItemClass) {
            itemType = ItemType.INC;
        }

        @Override
        public void visit(ProblemItemClass problemItemClass) {
            itemType = ItemType.PRB;
        }

        @Override
        public void visit(RfcItemClass rfcItemClass) {
            itemType = ItemType.RFC;
        }

        @Override
        public void visit(ServiceItemClass serviceItemClass) {
            itemType = ItemType.SVC;
        }
    }
}
