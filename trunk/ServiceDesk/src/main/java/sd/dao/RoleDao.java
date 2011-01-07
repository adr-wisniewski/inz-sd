package sd.dao;

import sd.infrastructure.dao.DictionaryDao;
import sd.domain.Role;

public interface RoleDao extends DictionaryDao<Role, String> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
