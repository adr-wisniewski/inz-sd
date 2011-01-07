/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.infrastructure.dao.CrudDao;
import sd.infrastructure.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface ItemClassDao extends CrudDao<ItemClass, Integer>, HierarchyDao<ItemClass, Integer>
{
    public ItemClass       getByName(String name);
    public List<ItemClass> searchByCriteria(ItemClassCriteria criteria);
}

