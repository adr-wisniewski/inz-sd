/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain.helper;

import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;

/**
 *
 * @author Adrian
 */
public interface EntityClassVisitor {
    public void visit(ItemClass itemClass);
    public void visit(RelationshipClass relationshipClass);
}
