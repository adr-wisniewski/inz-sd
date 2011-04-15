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
public class ProblemItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(3);
    protected static final String NAME = "Problem";
    protected static final String DESCRIPTION = "Problem";

    public ProblemItemClass() {
        super(ID, NAME, DESCRIPTION);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
