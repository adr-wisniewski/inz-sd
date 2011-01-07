package sd.pm.dao;

import java.util.List;

import sd.pm.app.KnownErrorSearchCriteria;
import sd.pm.domain.KnownError;

public interface KnownErrorDao {
	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria);
}
