package servicedesk.dao;

import servicedesk.infrastructure.dao.DictionaryDao;
import servicedesk.domain.Role;

public interface RoleDao extends DictionaryDao<Role, String> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
