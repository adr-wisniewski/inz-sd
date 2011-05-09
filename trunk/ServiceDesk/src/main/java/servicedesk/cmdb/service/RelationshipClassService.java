/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.infrastructure.general.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassService extends CrudService<RelationshipClass, Integer> {
    public RelationshipClass getByName(String name);
    public List<RelationshipClass> getAll();
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass);
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass);
    public List<RelationshipClass> search(RelationshipClassCriteria criteria);
}
