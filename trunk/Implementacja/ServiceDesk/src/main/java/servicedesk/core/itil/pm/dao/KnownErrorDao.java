package servicedesk.core.itil.pm.dao;

import java.util.List;

import servicedesk.core.itil.pm.app.KnownErrorSearchCriteria;
import servicedesk.core.itil.pm.domain.KnownError;

public interface KnownErrorDao {
	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria);
}
