/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EntityClassRedirectorVisitor implements EntityClassVisitor<String> {

    @Autowired
    protected EntityClassLinkVisitor linkVisitor;

    public String process(EntityClass target) {
        return target.accept(this);
    }

    protected String decorateUrl(String url) {
        return "redirect:" + url;
    }

    @Override
    public String visit(ItemClass itemClass) {
        return decorateUrl(linkVisitor.visit(itemClass));
    }

    @Override
    public String visit(RelationshipClass relationshipClass) {
        return decorateUrl(linkVisitor.visit(relationshipClass));
    }
}
