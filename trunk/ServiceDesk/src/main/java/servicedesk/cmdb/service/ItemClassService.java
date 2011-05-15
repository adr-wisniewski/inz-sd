/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import servicedesk.cmdb.domain.ItemClass;
import servicedesk.infrastructure.general.service.GetService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface ItemClassService 
    extends GetService<ItemClass, Integer>, 
        NamedService<ItemClass, Integer> {

}
