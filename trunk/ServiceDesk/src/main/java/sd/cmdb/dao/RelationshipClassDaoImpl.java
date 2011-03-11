/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.RelationshipClassCriteria;
import sd.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RelationshipClassDaoImpl extends AbstractHibernateCrudDao<RelationshipClass, Integer>implements RelationshipClassDao {

    @Override
    public RelationshipClass getByName(String name) {
        List<RelationshipClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findByName", "name", name);
        return DataAccessUtils.singleResult(list);
    }

    @Override
    public List<RelationshipClass> searchByCriteria(final RelationshipClassCriteria searchcriteria) {
        if(!searchcriteria.isInitialized())
            return new ArrayList<RelationshipClass>();


        HibernateCallback<List<RelationshipClass>> callback = new HibernateCallback<List<RelationshipClass>>() {

            @Override
            public List<RelationshipClass> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(RelationshipClass.class);
                initSearchCriteria(criteria, searchcriteria);
                return criteria.list();
            }
        };
    
        return getHibernateTemplate().execute(callback);
    }


    protected void initSearchCriteria(Criteria hibernateCriteria, RelationshipClassCriteria searchCriteria) {

        if(searchCriteria.getId() != null)
            hibernateCriteria.add(Restrictions.eq("id", searchCriteria.getId()));

        if(StringUtils.hasText(searchCriteria.getParentName())) {
            hibernateCriteria.createAlias("parent", "p");
            hibernateCriteria.add(Restrictions.like("p.name", searchCriteria.getParentName()));
        }

        if(StringUtils.hasText(searchCriteria.getName()))
            hibernateCriteria.add(Restrictions.like("name", searchCriteria.getName()));

        if(StringUtils.hasText(searchCriteria.getDescription()))
            hibernateCriteria.add(Restrictions.like("description", searchCriteria.getDescription()));

        if(searchCriteria.getAbstraction() != null) {
            hibernateCriteria.add(Restrictions.eq("abstraction", searchCriteria.getAbstraction()));
        }
    }

}
