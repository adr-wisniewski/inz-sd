/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.change.domain.entity.RfcImpl;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_RFC")
public class RfcItem extends Item {
    private static final long serialVersionUID = 1L;
    private RfcImpl rfc;
    private RfcItemClass rfcItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "RFC_ID")
    public RfcImpl getRfc() {
        return rfc;
    }

    public void setRfc(RfcImpl rfc) {
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

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(rfc.getTitle());
        return builder.toString();
    }
}
