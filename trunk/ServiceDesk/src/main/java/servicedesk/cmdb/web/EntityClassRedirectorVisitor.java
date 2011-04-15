/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import servicedesk.cmdb.domain.EntityClass;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
public class EntityClassRedirectorVisitor implements EntityClassVisitor {

    EntityClassLinkVisitor decoratedVisitor = new EntityClassLinkVisitor();

    public static String process(EntityClass target) {
        EntityClassRedirectorVisitor visitor = new EntityClassRedirectorVisitor();
        target.accept(visitor);
        return visitor.getRedirectUrl();
    }

    public String getRedirectUrl() {
        return "redirect:" + decoratedVisitor.getLinkUrl();
    }

    @Override
    public void visit(ItemClass itemClass) {
        decoratedVisitor.visit(itemClass);
    }

    @Override
    public void visit(RelationshipClass relationshipClass) {
        decoratedVisitor.visit(relationshipClass);
    }
}
