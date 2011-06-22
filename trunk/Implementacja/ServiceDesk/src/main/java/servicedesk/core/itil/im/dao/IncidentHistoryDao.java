package servicedesk.core.itil.im.dao;

import java.util.List;

import servicedesk.core.itil.im.domain.IncidentHistory;

public interface IncidentHistoryDao {
	public List<IncidentHistory> findIncidentHistory(Integer incidentId);
}
