/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.infrastructure.dao.CrudDao;
import sd.infrastructure.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface UniversalItemClassDao extends HierarchyDao<UniversalItemClass, Integer>, CrudDao<UniversalItemClass, Integer>
{
    public UniversalItemClass       getByName(String name);
    public UniversalItemClass       loadByName(String name);
    public List<UniversalItemClass> searchByCriteria(ItemClassCriteria criteria);
}

