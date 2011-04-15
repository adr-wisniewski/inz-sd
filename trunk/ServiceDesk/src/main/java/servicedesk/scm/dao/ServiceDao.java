package servicedesk.scm.dao;

import servicedesk.scm.domain.Service;

public interface ServiceDao {
	public Service get(Integer id);
}
