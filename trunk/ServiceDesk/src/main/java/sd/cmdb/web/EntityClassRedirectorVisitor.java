/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
public class EntityClassRedirectorVisitor implements EntityClassVisitor {
    protected String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Override
    public void visit(ItemClass itemClass) {
        redirectUrl = String.format("redirect:/cmdb/item/class/%d", itemClass.getId());
    }

    @Override
    public void visit(RelationshipClass relatioshipClass) {
        redirectUrl = String.format("redirect:/cmdb/relationship/class/%d", relatioshipClass.getId());
    }
}
