/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.List;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.HierarchyDao;

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

