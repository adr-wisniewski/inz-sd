package sd.im.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.im.domain.IncidentHistory;

@Repository
@Transactional
public class IncidentHistoryDaoImpl extends GenericHibernateDao<IncidentHistory, Integer> implements IncidentHistoryDao {

	public IncidentHistoryDaoImpl() {
		super(IncidentHistory.class, Integer.class);
	}

    @Override
	public List<IncidentHistory> findIncidentHistory(Integer incidentId) {
		return findByNamedQuery("Incident.history", incidentId);
	}

}
