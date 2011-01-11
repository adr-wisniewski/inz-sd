/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.infrastructure.dao.AbstractHibernateCrudDao;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Repository
public class ItemClassDaoImpl extends AbstractHibernateCrudDao<ItemClass, Integer> implements ItemClassDao {

    @Override
    public ItemClass getByName(String name) {
        List<ItemClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("ItemClass.findByName", "name", name);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ItemClass> searchByCriteria(final ItemClassCriteria searchcriteria) {
        if(!searchcriteria.isInitialized())
            return new ArrayList<ItemClass>();

        return getHibernateTemplate().execute(new HibernateCallback<List<ItemClass>>() {

            @Override
            public List<ItemClass> doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Criteria criteria = session.createCriteria(ItemClass.class);
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

    @Override
    public List<ItemClass> getAll() {
        return getHibernateTemplate().loadAll(ItemClass.class);
    }

    @Override
    public ItemClass get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
