package sd.im.app;

import sd.im.impl.InMemoryRequestStatusDaoImpl;
import dictionary.DictionaryPropertyEditor;

public class RequestStatusEditor extends DictionaryPropertyEditor<RequestStatus> {

	public RequestStatusEditor() {
		super(new InMemoryRequestStatusDaoImpl());
	}
	
}
