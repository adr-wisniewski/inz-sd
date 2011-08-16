/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import java.util.List;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipDao extends CrudDao<Relationship, Integer> {
    public Relationship getSame(Relationship target);
    public List<Relationship> forItem(Item item);
}
