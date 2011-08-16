/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS")
@PrimaryKeyJoinColumn(name = "ITEM_ID")
public abstract class Item extends Entity {
    private List<Relationship> sourceRelationships;
    private List<Relationship> targetRelationships;
    private String label;

    @Column(name = "LABEL", length = 50)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    @Transient
    public abstract ItemClass getItemClass();

    public abstract void accept(ItemVisitor visitor);

    @Override
    @Transient
    public ItemClass getEntityClass() {
        return getItemClass();
    }

    @OneToMany(mappedBy = "sourceItem")
    public List<Relationship> getSourceRelationships() {
        return sourceRelationships;
    }
    
    public void setSourceRelationships(List<Relationship> sourceRelationships) {
        this.sourceRelationships = sourceRelationships;
    }
    
    @OneToMany(mappedBy = "targetItem")
    public List<Relationship> getTargetRelationships() {
        return targetRelationships;
    }
    
    public void setTargetRelationships(List<Relationship> targetRelationships) {
        this.targetRelationships = targetRelationships;
    }
}
