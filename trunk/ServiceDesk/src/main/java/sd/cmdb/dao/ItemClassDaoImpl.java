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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

/**
 *
 * @author Adrian
 */
@Repository
public class ItemClassDaoImpl extends HibernateDaoSupport implements ItemClassDao {

    @Autowired
    public ItemClassDaoImpl(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

    @Override
    public List<ItemClass> getAll() {
        return getHibernateTemplate().loadAll(ItemClass.class);
    }

    @Override
    public ItemClass getById(Integer id) {
        return getHibernateTemplate().get(ItemClass.class, id);
    }

    @Override
    public ItemClass getByName(String name) {
        List<ItemClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("ItemClass.findByName", "name", name);

        if(list.size() > 0)
            return list.get(0);

        return null;
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
                searchcriteria.initCriteria(criteria);

                return criteria.list();
            }
        });
    }

    @Override
    public void save(ItemClass itemClass) {
        getHibernateTemplate().save(itemClass);
    }

    @Override
    public void update(ItemClass itemClass) {
        getHibernateTemplate().merge(itemClass);
    }

    @Override
    public List<ItemClass> fetchAll() {
        return this.getAll();
    }

    @Override
    public ItemClass findById(Serializable id) {
        Integer i = Integer.valueOf((String)id);
        return this.getById(i);
    }

    @Override
    public void delete(ItemClass itemClass) {
        getHibernateTemplate().delete(itemClass);
    }

    @Override
    public void evict(ItemClass itemClass) {
        getHibernateTemplate().evict(itemClass);
    }
}
