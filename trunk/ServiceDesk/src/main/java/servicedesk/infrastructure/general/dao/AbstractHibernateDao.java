/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import servicedesk.infrastructure.general.util.GenericUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import servicedesk.extensions.hibernate.search.DetachedCriteriaBuilder;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.search.domain.Query;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public abstract class AbstractHibernateDao<Type extends DomainObject<Id>, Id extends Serializable> 
    extends HibernateDaoSupport 
    implements CrudDao<Type, Id> {

    @SuppressWarnings("unchecked")
    private Class<Type> typeClass = (Class<Type>)GenericUtil.getTypeArgument(AbstractHibernateDao.class, getClass(),0);
    @SuppressWarnings("unchecked")
    private Class<Id> idClass = (Class<Id>)GenericUtil.getTypeArgument(AbstractHibernateDao.class, getClass(),1);

    @Autowired
    private DetachedCriteriaBuilder criteriaBuilder;
    
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

    @Override
    public List<Type> getAll() {
        return getHibernateTemplate().loadAll(typeClass);
    }
    
    public Type getByName(String name) {
        return DataAccessUtils.singleResult(getByNameList(name));
    }
    
    public Type loadByName(String name) {
        return DataAccessUtils.requiredSingleResult(getByNameList(name));
    }
    
    protected List<Type> getByNameList(String name) {
        @SuppressWarnings("unchecked")
        List<Type> result = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(typeClass).add(Restrictions.eq("name", name)));
        return result;
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
    
    public List<Type> search(Query<Type> query) {
        DetachedCriteria criteria = criteriaBuilder.build(query);
        
        @SuppressWarnings("unchecked")
        List<Type> result = getHibernateTemplate().findByCriteria(criteria);
        return result;
    }
}
