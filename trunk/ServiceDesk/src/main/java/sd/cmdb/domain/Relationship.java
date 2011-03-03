/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_RELATIONS")
@PrimaryKeyJoinColumn(name = "RELATION_ID")
public class Relationship extends Entity {
    private RelationshipClass relationshipClass;
    private Item sourceItem;
    private Item targetItem;

    /**
     * @return the relationshipClass
     */
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="RELATION_CLASS_ID")
    public RelationshipClass getRelationshipClass() {
        return relationshipClass;
    }

    /**
     * @param relationshipClass the relationshipClass to set
     */
    public void setRelationshipClass(RelationshipClass relationshipClass) {
        this.relationshipClass = relationshipClass;
    }

    /**
     * @return the sourceItem
     */
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="SOURCE_ITEM_ID")
    public Item getSourceItem() {
        return sourceItem;
    }

    /**
     * @param sourceItem the sourceItem to set
     */
    public void setSourceItem(Item sourceItem) {
        this.sourceItem = sourceItem;
    }

    /**
     * @return the targetItem
     */
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="TARGET_ITEM_ID")
    public Item getTargetItem() {
        return targetItem;
    }

    /**
     * @param targetItem the targetItem to set
     */
    public void setTargetItem(Item targetItem) {
        this.targetItem = targetItem;
    }
}
