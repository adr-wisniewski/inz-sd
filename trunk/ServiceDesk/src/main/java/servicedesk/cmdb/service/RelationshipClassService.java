/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.io.Serializable;
import java.util.List;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.infrastructure.general.domain.NamedDomainObject;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RelationshipClassService 
    extends CrudService<RelationshipClass, Integer>,
        NamedService<RelationshipClass, Integer> {
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass);
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass);
    public List<RelationshipClass> search(RelationshipClassCriteria criteria);
}
