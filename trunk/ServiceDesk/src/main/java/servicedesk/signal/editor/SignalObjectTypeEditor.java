package servicedesk.signal.editor;


import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.signal.dao.SignalObjectTypeDao;

import servicedesk.signal.domain.SignalObjectType;


public class SignalObjectTypeEditor extends DictionaryPropertyEditor<SignalObjectType> {

	public SignalObjectTypeEditor(SignalObjectTypeDao signalObjectTypeDao) {
		super(signalObjectTypeDao);
	}
	
}