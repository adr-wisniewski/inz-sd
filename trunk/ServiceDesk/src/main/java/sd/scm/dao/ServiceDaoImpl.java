package sd.scm.dao;

import org.springframework.stereotype.Repository;

import sd.dao.GenericHibernateDao;
import sd.scm.domain.Service;

@Repository
public class ServiceDaoImpl extends GenericHibernateDao<Service,Integer> implements ServiceDao {

}
