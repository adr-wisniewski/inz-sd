package servicedesk.rf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.rf.app.RequestSearchCriteria;
import servicedesk.rf.domain.ServiceRequest;

@Repository
@Transactional
public class RequestDaoImpl extends GenericHibernateDao<ServiceRequest,Integer> implements RequestDao {

    @Override
    public List<ServiceRequest> search(RequestSearchCriteria searchCriteria) {
            return super.search(searchCriteria);
    }

    @Override
    public ServiceRequest getById(Integer id) {
            return super.get(id);
    }
}
