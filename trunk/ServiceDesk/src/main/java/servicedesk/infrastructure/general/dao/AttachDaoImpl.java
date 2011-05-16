/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import servicedesk.infrastructure.general.domain.DomainObject;

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
        if(object.getId() != null)
            getHibernateTemplate().lock(object, LockMode.NONE);
    }
    
    @Override
    public void detach(DomainObject<?> object) {
        if(object.getId() != null)
            getHibernateTemplate().evict(object);
    }
}
