package servicedesk.scm.dao;

import org.springframework.stereotype.Repository;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.scm.domain.Service;

@Repository
public class ServiceDaoImpl extends GenericHibernateDao<Service,Integer> implements ServiceDao {

}
