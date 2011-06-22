/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipDao extends CrudDao<Relationship, Integer> {
    public Relationship getSame(Relationship target);
}
