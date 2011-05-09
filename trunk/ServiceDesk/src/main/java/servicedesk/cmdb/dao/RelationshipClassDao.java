/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.List;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassDao extends HierarchyDao<RelationshipClass, Integer>, CrudDao<RelationshipClass, Integer> {
    public RelationshipClass getByName(String name);
    public List<RelationshipClass> searchByCriteria(RelationshipClassCriteria criteria);
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass);
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass);
}
