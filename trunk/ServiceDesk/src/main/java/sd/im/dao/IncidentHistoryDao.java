package sd.im.dao;

import java.util.List;

import sd.im.domain.IncidentHistory;

public interface IncidentHistoryDao {
	public List<IncidentHistory> findIncidentHistory(Integer incidentId);
}
