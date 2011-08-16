/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain.helper;

import servicedesk.core.itil.cmdb.domain.EntityClass;

/**
 *
 * @author Adrian
 */
public abstract class EntityClassUtils {

    public static boolean isSameOrSubclass(EntityClass parent, EntityClass subclass) {

        if(parent == null)
            return true;
        
        for(EntityClass current = subclass; current != null; current = current.getParent()) {
            if(current.equals(parent))
                return true;
        }

        return false;

    }

}
