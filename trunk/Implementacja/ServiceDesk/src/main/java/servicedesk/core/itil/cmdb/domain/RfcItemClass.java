/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import org.springframework.stereotype.Component;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class RfcItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(4);
    protected static final String NAME = "RFC";
    protected static final String DESCRIPTION = "RFC";

    public RfcItemClass() {
        super(ID, NAME, DESCRIPTION);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
