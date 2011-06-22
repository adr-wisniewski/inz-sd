package servicedesk.core.itil.scm.dao;

import servicedesk.core.itil.scm.domain.Service;

public interface ServiceDao {
	public Service get(Integer id);
}
