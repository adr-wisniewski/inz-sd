/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import sd.cm.domain.Rfc;
import sd.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_RFC")
public class RfcItem extends Item {
    private Rfc rfc;
    private RfcItemClass rfcItemClass;

    /**
     * @return the rfc
     */
    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "RFC_ID")
    public Rfc getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(Rfc rfc) {
        this.rfc = rfc;
    }

    @Override
    @Transient
    public RfcItemClass getItemClass() {
        return rfcItemClass;
    }

    public void setItemClass(RfcItemClass rfcItemClass) {
        this.rfcItemClass = rfcItemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
