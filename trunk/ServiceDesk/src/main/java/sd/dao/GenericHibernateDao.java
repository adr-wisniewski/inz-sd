package sd.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import sd.app.SearchCriteria;


public class GenericHibernateDao<Property> {
	private SessionFactory sessionFactory;
	/**
	 * Klasa 
	 * 
	 * Wykorzystywane przy wyszukiwaniu do pobraniu wszystkich wartosci.
	 * UWAGA !!! Nie wiem jak pobrac klase z Property.
	 */
	private Class<?> propertyClass;

	public Class<?> getPropertyClass() {
		return propertyClass;
	}

	public String getPropertyClassName() {
		return propertyClass.getName();
	}
	
	public void setPropertyClass(Class<?> propertyClass) {
		this.propertyClass = propertyClass;
	}

	public GenericHibernateDao(Class<?> propertyClass) {
		super();
		this.propertyClass = propertyClass;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> fetchAll() {
		return getSession().createQuery("from " + getPropertyClassName()).list();
	}
	
	public void save(Property object) {
		getSession().saveOrUpdate(object);
	}
	
	@SuppressWarnings("unchecked")
	public Property findById(Serializable id) {
		return (Property)getSession().get(propertyClass, id);
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
		Criteria criteria = getSession().createCriteria(propertyClass);
		searchCriteria.initCriteria(criteria);
		return criteria.list();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
