package sd.scm.dao;

import org.springframework.stereotype.Repository;

import sd.dao.GenericHibernateDao;
import sd.scm.domain.Service;

@Repository
public class ServiceDaoImpl extends GenericHibernateDao<Service,Integer> implements ServiceDao {

	public ServiceDaoImpl() {
		super(Service.class, Integer.class);
	}

	@Override
	public Service get(Integer id) {
		return super.get(id);
	}

}
