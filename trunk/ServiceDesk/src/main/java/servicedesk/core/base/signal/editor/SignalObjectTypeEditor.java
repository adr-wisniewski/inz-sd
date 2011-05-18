package servicedesk.core.base.signal.editor;


import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.signal.dao.SignalObjectTypeDao;

import servicedesk.core.base.signal.domain.SignalObjectType;


public class SignalObjectTypeEditor extends DictionaryPropertyEditor<SignalObjectType> {

	public SignalObjectTypeEditor(SignalObjectTypeDao signalObjectTypeDao) {
		super(signalObjectTypeDao);
	}
	
}