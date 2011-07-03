/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.stereotype.Component;
import servicedesk.core.itil.cmdb.domain.EntityClass;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class EntityClassLinkVisitor implements EntityClassVisitor<String> {

    public String process(EntityClass entityClass) {
        return entityClass.accept(this);
    }
    
    @Override
    public String visit(ItemClass itemClass) {
        return String.format("/cmdb/item/class/%d", itemClass.getId());
    }

    @Override
    public String visit(RelationshipClass relatioshipClass) {
        return String.format("/cmdb/relationship/class/%d", relatioshipClass.getId());
    }
}
