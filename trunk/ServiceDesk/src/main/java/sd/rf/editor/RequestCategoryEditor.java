package sd.rf.editor;

import sd.dictionary.DictionaryPropertyEditor;
import sd.rf.dao.RequestCategoryDao;
import sd.rf.domain.RequestCategory;

public class RequestCategoryEditor extends DictionaryPropertyEditor<RequestCategory>{

	public RequestCategoryEditor(RequestCategoryDao requestCategoryDao) {
		super(requestCategoryDao);
	}
 
}
