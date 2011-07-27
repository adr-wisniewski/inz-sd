/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_UNIVERSAL")
@NamedQueries({
    @NamedQuery(name = "UniversalItem.findByClass", query = "from UniversalItem u where u.itemClass = :itemClass")
})
public class UniversalItem extends Item {
    private static final long serialVersionUID = 1L;

    private UniversalItemClass itemClass;

    /**
     * package level constructor for hibernate
     */
    protected UniversalItem() {
        
    }
    
    public UniversalItem(UniversalItemClass itemClass) {
        this.itemClass = itemClass;
        populateAttributeValues();
    }
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CLASS_ID")
    @Override
    public UniversalItemClass getItemClass() {
        return itemClass;
    }

    protected void setItemClass(UniversalItemClass itemClass) {
        this.itemClass = itemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Transient
    @Override
    public String getOverview() {

        StringBuilder builder = new StringBuilder();
        List<Attribute> attributes = itemClass.getAllAttributesSorted();

        for(Attribute attribute: attributes) {
            if(attribute.isOverview()) {
                builder.append(this.getAttributeValue(attribute).getValue()).append(" ");
            }
        }

        return builder.toString();
    }
}
