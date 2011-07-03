package servicedesk.infrastructure.dao.hibernate;

import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.search.SearchObject;
import servicedesk.infrastructure.util.GenericUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import servicedesk.infrastructure.interfaces.dao.SearchDao;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.infrastructure.search.QueryFactory;
import servicedesk.infrastructure.search.criterion.Query;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public abstract class AbstractHibernateDao<AbstractType extends DomainObject<Id>, ConcreteType extends AbstractType, Id extends Serializable> 
    extends HibernateDaoSupport 
    implements CrudDao<AbstractType, Id>, SearchDao<AbstractType, Id> {

    @SuppressWarnings("unchecked")
    private Class<ConcreteType> typeClass = (Class<ConcreteType>)GenericUtil.getTypeArgument(AbstractHibernateDao.class, getClass(),1);
    @SuppressWarnings("unchecked")
    private Class<Id> idClass = (Class<Id>)GenericUtil.getTypeArgument(AbstractHibernateDao.class, getClass(),2);
    @Autowired
    private HibernateQueryMapper queryMapper;
    @Autowired
    protected QueryFactory criteriaFactory;
    
    @Autowired
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Class<ConcreteType> getTypeClass() {
        return typeClass;
    }

    public Class<Id> getIdClass() {
        return idClass;
    }

    @Override
    public ConcreteType load(Id id) {
        return getHibernateTemplate().load(typeClass, id);
    }

    @Override
    public ConcreteType get(Id id) {
        return getHibernateTemplate().get(typeClass, id);
    }

    @Override
    public List<AbstractType> getAll() {
        return (List<AbstractType>)getHibernateTemplate().loadAll(typeClass);
    }
    
    public ConcreteType getByName(String name) {
        return DataAccessUtils.singleResult(getByNameList(name));
    }
    
    public ConcreteType loadByName(String name) {
        return DataAccessUtils.requiredSingleResult(getByNameList(name));
    }
    
    protected List<ConcreteType> getByNameList(String name) {
        @SuppressWarnings("unchecked")
        List<ConcreteType> result = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(typeClass).add(Restrictions.eq("name", name)));
        return result;
    }

    @Override
    public void persist(AbstractType object) {
        getHibernateTemplate().persist(object);
    }

    @Override
    public void remove(AbstractType object) {
        getHibernateTemplate().delete(object);
    }
    
    @Override
    public AbstractType merge(AbstractType object) {
        return getHibernateTemplate().merge(object);
    }

    @Override
    public List<AbstractType> search(SearchObject<AbstractType> searchObject) {
        Query query = criteriaFactory.getCriteria(typeClass, searchObject);
        if(query.isEmpty() && !query.isAllowEmptyQueries())
            return new ArrayList<AbstractType>(0);
        
        DetachedCriteria criteria = queryMapper.map(query);
        @SuppressWarnings("unchecked")
        List<AbstractType> result = getHibernateTemplate().findByCriteria(criteria);
        return result;
    }
}
