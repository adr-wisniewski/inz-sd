/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.List;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.infrastructure.general.dao.Dao;
import servicedesk.infrastructure.general.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends HierarchyDao<ItemClass, Integer>, Dao<ItemClass, Integer> {
    public ItemClass load(Integer id);
    public ItemClass getByName(String name);
    public ItemClass loadByName(String name);
}
