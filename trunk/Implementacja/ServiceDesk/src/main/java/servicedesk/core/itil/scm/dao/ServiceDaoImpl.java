package servicedesk.core.itil.scm.dao;

import org.springframework.stereotype.Repository;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.itil.scm.domain.Service;

@Repository
public class ServiceDaoImpl extends GenericHibernateDao<Service,Integer> implements ServiceDao {

}
