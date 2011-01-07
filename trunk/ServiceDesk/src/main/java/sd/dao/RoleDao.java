package sd.dao;

import sd.dictionary.DictionaryPropertyDao;
import sd.domain.Role;

public interface RoleDao extends DictionaryPropertyDao<Role> {
	/**
	 * @param roleCode kod roli
	 * @return zwraca role na podstawie kodu
	 */
	public Role findByCode(String roleCode);

}
