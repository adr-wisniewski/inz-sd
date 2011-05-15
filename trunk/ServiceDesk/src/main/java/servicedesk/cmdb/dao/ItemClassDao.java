/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import servicedesk.cmdb.domain.ItemClass;
import servicedesk.infrastructure.general.dao.HierarchyDao;
import servicedesk.infrastructure.general.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends HierarchyDao<ItemClass, Integer>, NamedDao<ItemClass, Integer> {

}
