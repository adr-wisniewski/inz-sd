package servicedesk.editor;

import servicedesk.dao.RoleDao;
import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.infrastructure.security.domain.Role;

public class RoleEditor extends DictionaryPropertyEditor<Role> {

	public RoleEditor(RoleDao roleDao) {
		super(roleDao);
	}
	
}
