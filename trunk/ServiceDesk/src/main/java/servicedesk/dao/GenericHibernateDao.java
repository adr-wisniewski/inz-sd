package servicedesk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import servicedesk.app.SearchCriteria;
import servicedesk.infrastructure.domain.DomainObject;
import servicedesk.infrastructure.util.GenericUtil;


public class GenericHibernateDao<Property extends DomainObject<Id>, Id extends Serializable> {
	private SessionFactory sessionFactory;

	private Class<Property> typeClass = (Class<Property>)GenericUtil
            .getTypeArgument(GenericHibernateDao.class, getClass(), 0);

        private Class<Id> idClass = (Class<Id>)GenericUtil
            .getTypeArgument(GenericHibernateDao.class, getClass(), 1);

	public Class<Property> getTypeClass() {
		return typeClass;
	}

        public Class<Id> getIdClass() {
		return idClass;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> getAll() {
		return getSession().createQuery("from " + getTypeClass().getName()).list();
	}
	
	public void save(Property object) {
		getSession().saveOrUpdate(object);
	}
	
	@SuppressWarnings("unchecked")
	public Property get(Id id) {
		return (Property)getSession().get(typeClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> findByNamedQuery(String queryName, Object value) {
		return getSession().getNamedQuery(queryName).setParameter(0, value).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> findByNamedQuery(String queryName) {
		return getSession().getNamedQuery(queryName).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> search(SearchCriteria<Property> searchCriteria) {
		Criteria criteria = getSession().createCriteria(typeClass);
		searchCriteria.initCriteria(criteria);
		return criteria.list();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
