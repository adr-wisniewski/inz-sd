/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain.helper;

import servicedesk.cmdb.domain.EntityClass;

/**
 *
 * @author Adrian
 */
public abstract class EntityClassUtils {

    public static boolean isSameOrSubclass(EntityClass parent, EntityClass subclass) {

        for(EntityClass current = subclass; current != null; current = current.getParent()) {
            if(current.equals(parent))
                return true;
        }

        return false;

    }

}