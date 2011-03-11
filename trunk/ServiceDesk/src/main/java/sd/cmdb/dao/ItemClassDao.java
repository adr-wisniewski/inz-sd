/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.dao.Dao;
import sd.infrastructure.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends HierarchyDao<ItemClass, Integer>, Dao<ItemClass, Integer> {
    public ItemClass load(Integer id);
    public ItemClass getByName(String name);
    public ItemClass loadByName(String name);
}
