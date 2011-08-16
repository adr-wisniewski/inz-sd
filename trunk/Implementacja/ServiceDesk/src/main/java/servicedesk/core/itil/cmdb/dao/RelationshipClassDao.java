/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import java.util.List;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.HierarchyDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassDao 
    extends HierarchyDao<RelationshipClass, Integer>, 
        CrudDao<RelationshipClass, Integer>,
        NamedDao<RelationshipClass, Integer> {
    public List<RelationshipClass> searchByCriteria(RelationshipClassCriteria criteria);
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass);
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass);
    public List<RelationshipClass> getAllForClass(ItemClass itemClass);
}
