/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import java.util.List;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.interfaces.service.EditService;

/**
 *
 * @author Adrian
 */
public interface RelationshipService extends EditService<Relationship, Integer> {
    public Relationship getSame(Relationship target);
    public List<Relationship> forItem(Item item);
}
