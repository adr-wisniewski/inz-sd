package servicedesk.core.base.security.dao;

import servicedesk.infrastructure.interfaces.dao.DictionaryDao;
import servicedesk.core.base.security.domain.Role;

public interface RoleDao extends DictionaryDao<Role, String> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
