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
public class ServiceItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(5);
    protected static final String NAME = "Usługa";
    protected static final String DESCRIPTION = "Usługa";

    public ServiceItemClass() {
        super(ID, NAME, DESCRIPTION);
    }
    
    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
