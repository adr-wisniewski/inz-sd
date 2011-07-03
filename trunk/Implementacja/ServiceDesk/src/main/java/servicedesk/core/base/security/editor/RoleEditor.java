package servicedesk.core.base.security.editor;

import servicedesk.core.base.security.dao.RoleDao;
import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.security.domain.Role;

public class RoleEditor extends DictionaryPropertyEditor<Role> {

	public RoleEditor(RoleDao roleDao) {
		super(roleDao);
	}
	
}
