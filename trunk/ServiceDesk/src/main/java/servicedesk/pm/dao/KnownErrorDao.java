package servicedesk.pm.dao;

import java.util.List;

import servicedesk.pm.app.KnownErrorSearchCriteria;
import servicedesk.pm.domain.KnownError;

public interface KnownErrorDao {
	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria);
}
