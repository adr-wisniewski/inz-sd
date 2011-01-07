package sd.scm.dao;

import org.springframework.stereotype.Repository;

import sd.dao.GenericHibernateDao;
import sd.scm.domain.Service;

@Repository
public class ServiceDaoImpl extends GenericHibernateDao<Service> implements ServiceDao {

	public ServiceDaoImpl() {
		super(Service.class);
	}

	@Override
	public Service findById(Integer id) {
		return super.findById(id);
	}

}
