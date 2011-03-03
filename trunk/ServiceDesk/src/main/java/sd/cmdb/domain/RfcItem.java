/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import sd.cm.domain.Rfc;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_RFC")
public class RfcItem extends Item {
    private Rfc rfc;

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
}
