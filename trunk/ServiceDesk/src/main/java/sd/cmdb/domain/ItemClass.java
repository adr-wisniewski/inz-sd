/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import sd.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
public interface ItemClass extends EntityClass {
    @Override
    public ItemClass getParent();
    public void accept(ItemClassVisitor visitor);
}
