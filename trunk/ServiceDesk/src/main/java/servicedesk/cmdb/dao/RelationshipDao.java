/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import servicedesk.cmdb.domain.Relationship;
import servicedesk.infrastructure.general.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface RelationshipDao extends CrudDao<Relationship, Integer> {
    public Relationship getSame(Relationship target);
}
