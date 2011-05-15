/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.change.domain.Rfc;
import servicedesk.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_RFC")
public class RfcItem extends Item {
    private static final long serialVersionUID = 1L;
    private Rfc rfc;
    private RfcItemClass rfcItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "RFC_ID")
    public Rfc getRfc() {
        return rfc;
    }

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

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(rfc.getTitle());
        return builder.toString();
    }
}
