/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.dao;

import sd.infrastructure.util.GenericUtil;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public abstract class AbstractHibernateCrudDao<Type extends DomainObject<Id>, Id extends Serializable> extends HibernateDaoSupport implements CrudDao<Type, Id> {

    protected Class<Type> typeClass = (Class<Type>)GenericUtil.getTypeArgument(AbstractHibernateCrudDao.class, getClass(),0);
    protected Class<Id> idClass = (Class<Id>)GenericUtil.getTypeArgument(AbstractHibernateCrudDao.class, getClass(), 1);

    @Override
    public Class<Type> getTypeClass() {
        return typeClass;
    }

    @Override
    public Class<Id> getIdClass() {
        return idClass;
    }

    @Autowired
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public Type load(Id id) {
        return getHibernateTemplate().load(typeClass, id);
    }

    @Override
    public Type get(Id id) {
        return getHibernateTemplate().get(typeClass, id);
    }

    @Override
    public void persist(Type object) {
        getHibernateTemplate().persist(object);
    }

    @Override
    public void remove(Type object) {
        getHibernateTemplate().delete(object);
    }
    
    @Override
    public Type merge(Type object) {
        return getHibernateTemplate().merge(object);
    }
}
