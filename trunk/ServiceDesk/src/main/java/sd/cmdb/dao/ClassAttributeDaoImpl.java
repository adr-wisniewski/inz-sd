/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributePk;

/**
 *
 * @author Adrian
 */
@Repository
public class ClassAttributeDaoImpl extends HibernateDaoSupport implements ClassAttributeDao {

    @Autowired
    public ClassAttributeDaoImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void save(ClassAttribute classAttribute) {
        getHibernateTemplate().save(classAttribute);
    }

    @Override
    public void update(ClassAttribute classAttribute) {
         getHibernateTemplate().merge(classAttribute);
    }

    @Override
    public void delete(ClassAttribute classAttribute) {
        getHibernateTemplate().delete(classAttribute);
    }

    @Override
    public ClassAttribute load(ClassAttributePk classAttributePk) throws DataAccessException {
        return getHibernateTemplate().load(ClassAttribute.class, classAttributePk);
    }

}


//TODO: double submit problem
//TODO: error pages
//TODO: prg form expired view
//TODO: holding data in session for all forms?