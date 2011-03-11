/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import sd.cmdb.domain.EntityClass;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.EntityClassVisitor;

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
