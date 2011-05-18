/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import java.io.Serializable;
import java.util.List;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.infrastructure.interfaces.domain.NamedDomainObject;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.interfaces.service.NamedService;

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
