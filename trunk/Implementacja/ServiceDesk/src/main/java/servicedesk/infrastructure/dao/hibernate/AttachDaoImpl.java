/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.dao.hibernate;

import servicedesk.infrastructure.interfaces.dao.AttachDao;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Repository
public class AttachDaoImpl extends HibernateDaoSupport implements AttachDao {
    
    @Autowired
    protected void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
   
    @Override
    public void attach(DomainObject<?> object) {
        if(object.getId() != null && !getHibernateTemplate().contains(object))
            getHibernateTemplate().lock(object, LockMode.NONE);
    }
    
    @Override
    public void detach(DomainObject<?> object) {
        if(object.getId() != null && getHibernateTemplate().contains(object))
            getHibernateTemplate().evict(object);
    }
}
