package servicedesk.rf.editor;

import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.rf.dao.RequestCategoryDao;
import servicedesk.rf.domain.RequestCategory;

public class RequestCategoryEditor extends DictionaryPropertyEditor<RequestCategory>{

	public RequestCategoryEditor(RequestCategoryDao requestCategoryDao) {
		super(requestCategoryDao);
	}
 
}
