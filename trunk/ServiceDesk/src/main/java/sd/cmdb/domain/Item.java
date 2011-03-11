/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.Collections;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import sd.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS")
@PrimaryKeyJoinColumn(name = "ITEM_ID")
public abstract class Item extends Entity {
   @Transient
   public abstract ItemClass getItemClass();

   public abstract void accept(ItemVisitor visitor);

   public void populateAttributeValues() {
        for(Attribute attribute: getItemClass().getAllAttributes()) {
            getAttributeValue(attribute);
            Collections.sort(getAttributeValues());
        }
    }
}
