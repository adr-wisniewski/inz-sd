/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.infrastructure.interfaces.service.LoadService;
import servicedesk.infrastructure.interfaces.service.HierarchyService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface ItemClassService 
    extends LoadService<ItemClass, Integer>, 
        NamedService<ItemClass, Integer>,
        HierarchyService<ItemClass, Integer> {

}
