/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.io.Serializable;
import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.tree.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends HierarchyDao<ItemClass>
{
    public List<ItemClass> getAll();
    public ItemClass       getById(Integer id);
    public ItemClass       getByName(String name);
    public List<ItemClass> searchByCriteria(ItemClassCriteria criteria);

    public void save(ItemClass itemClass);
    public void update(ItemClass itemClass);
    public void delete(ItemClass itemClass);
    public void evict(ItemClass itemClass);
}

