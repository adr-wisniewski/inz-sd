package sd.rf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.rf.app.RequestSearchCriteria;
import sd.rf.domain.ServiceRequest;

@Repository
@Transactional
public class RequestDaoImpl extends GenericHibernateDao<ServiceRequest> implements RequestDao {

	public RequestDaoImpl() {
		super(ServiceRequest.class);
	}

	public ServiceRequest findById(Integer id) {
		return super.findById(id);
	}

	public List<ServiceRequest> search(RequestSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}

	public ServiceRequest getById(Integer id) {
		return super.findById(id);
	}
}
