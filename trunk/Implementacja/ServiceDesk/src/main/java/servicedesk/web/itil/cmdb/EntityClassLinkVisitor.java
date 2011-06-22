/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import servicedesk.core.itil.cmdb.domain.EntityClass;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
public class EntityClassLinkVisitor implements EntityClassVisitor {
    protected String linkUrl;

    public static String process(EntityClass target) {
        EntityClassLinkVisitor visitor = new EntityClassLinkVisitor();
        target.accept(visitor);
        return visitor.getLinkUrl();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    @Override
    public void visit(ItemClass itemClass) {
        linkUrl = String.format("/cmdb/item/class/%d", itemClass.getId());
    }

    @Override
    public void visit(RelationshipClass relatioshipClass) {
        linkUrl = String.format("/cmdb/relationship/class/%d", relatioshipClass.getId());
    }
}
