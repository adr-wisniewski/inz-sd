/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.interfaces.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface RelationshipService extends CrudService<Relationship, Integer> {
    public Relationship getSame(Relationship target);
}
