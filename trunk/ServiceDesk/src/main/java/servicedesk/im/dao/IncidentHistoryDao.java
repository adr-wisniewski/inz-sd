package servicedesk.im.dao;

import java.util.List;

import servicedesk.im.domain.IncidentHistory;

public interface IncidentHistoryDao {
	public List<IncidentHistory> findIncidentHistory(Integer incidentId);
}
