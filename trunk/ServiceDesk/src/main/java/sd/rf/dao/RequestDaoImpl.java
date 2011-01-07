package sd.rf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.rf.app.RequestSearchCriteria;
import sd.rf.domain.ServiceRequest;

@Repository
@Transactional
public class RequestDaoImpl extends GenericHibernateDao<ServiceRequest,Integer> implements RequestDao {

	public RequestDaoImpl() {
		super(ServiceRequest.class, Integer.class);
	}

    @Override
	public ServiceRequest get(Integer id) {
		return super.get(id);
	}

    @Override
	public List<ServiceRequest> search(RequestSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}

    @Override
	public ServiceRequest getById(Integer id) {
		return super.get(id);
	}
}
