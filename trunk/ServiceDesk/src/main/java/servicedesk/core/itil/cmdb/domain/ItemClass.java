/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
public interface ItemClass extends EntityClass {
    @Override
    public ItemClass getParent();
    public void accept(ItemClassVisitor visitor);
}
