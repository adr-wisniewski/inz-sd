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
public class IncidentItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(2);
    protected static final String NAME = "Incydent";
    protected static final String DESCRIPTION = "Incydent";

    public IncidentItemClass() {
        super(ID, NAME, DESCRIPTION);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
