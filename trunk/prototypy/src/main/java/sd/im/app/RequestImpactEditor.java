package sd.im.app;

import sd.im.impl.InMemoryRequestImpactDao;
import dictionary.DictionaryPropertyEditor;

public class RequestImpactEditor extends DictionaryPropertyEditor<RequestImpact> {

	public RequestImpactEditor() {
		super(new InMemoryRequestImpactDao());
	}

}
