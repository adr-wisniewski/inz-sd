/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.infrastructure.interfaces.dao.HierarchyDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends HierarchyDao<ItemClass, Integer>, NamedDao<ItemClass, Integer> {

}
