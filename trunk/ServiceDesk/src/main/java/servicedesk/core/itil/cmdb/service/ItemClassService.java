/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.infrastructure.interfaces.service.GetService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface ItemClassService 
    extends GetService<ItemClass, Integer>, 
        NamedService<ItemClass, Integer> {

}
