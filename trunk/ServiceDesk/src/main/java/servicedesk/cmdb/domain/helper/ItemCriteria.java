/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain.helper;

import org.springframework.util.StringUtils;
import servicedesk.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
public class ItemCriteria {

    private String label;
    private ItemClass itemClass;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ItemClass getItemClass() {
        return itemClass;
    }

    public void setItemClass(ItemClass itemClass) {
        this.itemClass = itemClass;
    }

    public boolean isInitialized() {
        return StringUtils.hasText(label);
    }

}
