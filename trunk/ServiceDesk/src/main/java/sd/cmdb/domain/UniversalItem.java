/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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

    private UniversalItemClass itemClass;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GENERIC_CLASS_ID")
    public UniversalItemClass getItemClass() {
        return itemClass;
    }

    public void setItemClass(UniversalItemClass itemClass) {
        this.itemClass = itemClass;
    }
}
