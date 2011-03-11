/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.RelationshipClassCriteria;
import sd.infrastructure.dao.CrudDao;
import sd.infrastructure.dao.HierarchyDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassDao extends HierarchyDao<RelationshipClass, Integer>, CrudDao<RelationshipClass, Integer> {
    public RelationshipClass getByName(String name);
    public List<RelationshipClass> searchByCriteria(RelationshipClassCriteria criteria);
}
