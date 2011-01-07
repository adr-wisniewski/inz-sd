package sd.editor;

import sd.dao.RoleDao;
import sd.dictionary.DictionaryPropertyEditor;
import sd.domain.Role;

public class RoleEditor extends DictionaryPropertyEditor<Role> {

	public RoleEditor(RoleDao roleDao) {
		super(roleDao);
	}
	
}
