/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain.helper;

import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.RelationshipClass;

/**
 *
 * @author Adrian
 */
public interface EntityClassVisitor {
    public void visit(ItemClass itemClass);
    public void visit(RelationshipClass relationshipClass);
}
