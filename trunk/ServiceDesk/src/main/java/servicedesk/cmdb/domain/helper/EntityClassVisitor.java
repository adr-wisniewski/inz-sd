/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain.helper;

import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;

/**
 *
 * @author Adrian
 */
public interface EntityClassVisitor {
    public void visit(ItemClass itemClass);
    public void visit(RelationshipClass relationshipClass);
}
