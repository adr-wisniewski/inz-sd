/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import servicedesk.infrastructure.general.util.GenericUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public abstract class AbstractHibernateCrudDao<Type extends DomainObject<Id>, Id extends Serializable> extends HibernateDaoSupport implements CrudDao<Type, Id> {

    private Class<Type> typeClass = (Class<Type>)GenericUtil.getTypeArgument(AbstractHibernateCrudDao.class, getClass(),0);
    private Class<Id> idClass = (Class<Id>)GenericUtil.getTypeArgument(AbstractHibernateCrudDao.class, getClass(),1);

    @Autowired
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Class<Type> getTypeClass() {
        return typeClass;
    }

    public Class<Id> getIdClass() {
        return idClass;
    }

    @Override
    public Type load(Id id) {
        return getHibernateTemplate().load(typeClass, id);
    }

    @Override
    public Type get(Id id) {
        return getHibernateTemplate().get(typeClass, id);
    }

    public List<Type> getAll() {
        return getHibernateTemplate().loadAll(typeClass);
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
