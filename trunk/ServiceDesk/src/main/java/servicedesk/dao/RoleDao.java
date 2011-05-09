package servicedesk.dao;

import servicedesk.infrastructure.general.dao.DictionaryDao;
import servicedesk.infrastructure.security.domain.Role;

public interface RoleDao extends DictionaryDao<Role, String> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
