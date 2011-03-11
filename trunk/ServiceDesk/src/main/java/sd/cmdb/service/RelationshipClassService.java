/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.RelationshipClassCriteria;
import sd.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassService extends CrudService<RelationshipClass, Integer> {
    public RelationshipClass getByName(String name);
    public List<RelationshipClass> getAll();
    public List<RelationshipClass> search(RelationshipClassCriteria criteria);
}
