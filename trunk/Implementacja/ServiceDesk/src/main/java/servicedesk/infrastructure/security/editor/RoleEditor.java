package servicedesk.infrastructure.security.editor;

import servicedesk.infrastructure.security.dao.RoleDao;
import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.infrastructure.security.domain.Role;

public class RoleEditor extends DictionaryPropertyEditor<Role> {

	public RoleEditor(RoleDao roleDao) {
		super(roleDao);
	}
	
}
