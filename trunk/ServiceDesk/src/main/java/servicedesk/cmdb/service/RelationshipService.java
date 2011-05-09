/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import servicedesk.cmdb.domain.Relationship;
import servicedesk.infrastructure.general.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface RelationshipService extends CrudService<Relationship, Integer> {
    public Relationship getSame(Relationship target);
}
