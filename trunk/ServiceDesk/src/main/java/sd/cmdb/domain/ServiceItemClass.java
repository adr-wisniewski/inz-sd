/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import sd.cmdb.domain.helper.EntityClassVisitor;
import sd.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class ServiceItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(5);
    protected static final String NAME = "Usługa";
    protected static final String DESCRIPTION = "Usługa";
    protected static final List<Attribute> ATTRIBUTES = new ArrayList<Attribute>();

    public ServiceItemClass() {
        super(ID, NAME, DESCRIPTION, ATTRIBUTES);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
