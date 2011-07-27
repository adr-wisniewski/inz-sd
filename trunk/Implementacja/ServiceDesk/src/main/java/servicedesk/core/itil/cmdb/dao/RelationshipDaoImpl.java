/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RelationshipDaoImpl extends AbstractHibernateDao<Relationship, Relationship, Integer> implements RelationshipDao {

    @Override
    public Relationship getSame(Relationship target) {
        String[] params = new String[]{"clazz", "source", "target"};
        Object[] values = new Object[]{target.getRelationshipClass(), target.getSourceItem(), target.getTargetItem()};
        
        @SuppressWarnings("unchecked")
        List<Relationship> list = getHibernateTemplate().findByNamedQueryAndNamedParam("Relationship.findSame", params, values);
        return DataAccessUtils.singleResult(list);
    }

}
