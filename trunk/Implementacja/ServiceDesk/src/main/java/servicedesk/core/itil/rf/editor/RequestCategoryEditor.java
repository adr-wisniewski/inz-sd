package servicedesk.core.itil.rf.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.rf.dao.RequestCategoryDao;
import servicedesk.core.itil.rf.domain.RequestCategory;

public class RequestCategoryEditor extends DictionaryPropertyEditor<RequestCategory>{

	public RequestCategoryEditor(RequestCategoryDao requestCategoryDao) {
		super(requestCategoryDao);
	}
 
}
