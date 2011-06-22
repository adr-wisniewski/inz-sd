package servicedesk.infrastructure.security.dao;

import servicedesk.infrastructure.interfaces.dao.DictionaryDao;
import servicedesk.infrastructure.security.domain.Role;

public interface RoleDao extends DictionaryDao<Role, String> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
