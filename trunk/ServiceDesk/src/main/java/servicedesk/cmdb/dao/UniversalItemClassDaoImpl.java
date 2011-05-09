/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

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
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UniversalItemClassDaoImpl extends AbstractHibernateCrudDao<UniversalItemClass, Integer> implements UniversalItemClassDao {

    @Override
    public UniversalItemClass getByName(String name) {
        List<UniversalItemClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("UniversalItemClass.findByName", "name", name);
        return DataAccessUtils.singleResult(list);
    }
    
    @Override
    public UniversalItemClass loadByName(String name) {
        List<UniversalItemClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("UniversalItemClass.findByName", "name", name);
        return DataAccessUtils.requiredSingleResult(list);
    }

    @Override
    public List<UniversalItemClass> searchByCriteria(final ItemClassCriteria searchcriteria) {
        if(!searchcriteria.isInitialized())
            return new ArrayList<UniversalItemClass>();

        return getHibernateTemplate().execute(new HibernateCallback<List<UniversalItemClass>>() {

            @Override
            public List<UniversalItemClass> doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Criteria criteria = session.createCriteria(UniversalItemClass.class);
                initSearchCriteria(criteria, searchcriteria);
                return criteria.list();
            }
        });
    }


    protected void initSearchCriteria(Criteria hibernateCriteria, ItemClassCriteria searchCriteria) {

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
