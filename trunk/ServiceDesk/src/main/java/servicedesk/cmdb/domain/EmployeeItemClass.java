/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import org.springframework.stereotype.Component;
import servicedesk.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class EmployeeItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(1);
    protected static final String NAME = "Pracownik";
    protected static final String DESCRIPTION = "Pracownik";

    public EmployeeItemClass() {
        super(ID, NAME, DESCRIPTION);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
