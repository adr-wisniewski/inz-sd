package sd.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import sd.app.SearchCriteria;
import sd.infrastructure.dao.Dao;
import sd.infrastructure.domain.DomainObject;


public class GenericHibernateDao<Property extends DomainObject<Id>, Id extends Serializable> implements Dao<Property, Id> {
	private SessionFactory sessionFactory;
	/**
	 * Klasa 
	 * 
	 * Wykorzystywane przy wyszukiwaniu do pobraniu wszystkich wartosci.
	 * UWAGA !!! Nie wiem jak pobrac klase z Property.
	 */
	private Class<Property> typeClass;
        private Class<Id> idClass;

        @Override
	public Class<Property> getTypeClass() {
		return typeClass;
	}
	
        @Override
	public Class<Id> getIdClass() {
            return idClass;
        }

	public GenericHibernateDao(Class<Property> propertyClass, Class<Id> idClass) {
		this.typeClass = propertyClass;
                this.idClass = idClass;
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
