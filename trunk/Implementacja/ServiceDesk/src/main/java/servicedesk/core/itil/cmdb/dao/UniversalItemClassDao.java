/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import java.util.List;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.HierarchyDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface UniversalItemClassDao 
    extends HierarchyDao<UniversalItemClass, Integer>, 
        CrudDao<UniversalItemClass, Integer>,
        NamedDao<UniversalItemClass, Integer> 
{
    public List<UniversalItemClass> searchByCriteria(ItemClassCriteria criteria);
}

