package servicedesk.im.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.im.domain.IncidentHistory;

@Repository
@Transactional
public class IncidentHistoryDaoImpl extends GenericHibernateDao<IncidentHistory, Integer> implements IncidentHistoryDao {

    @Override
    public List<IncidentHistory> findIncidentHistory(Integer incidentId) {
            return findByNamedQuery("Incident.history", incidentId);
    }

}
