package sd.signal.editor;


import sd.dictionary.DictionaryPropertyEditor;
import sd.signal.dao.SignalObjectTypeDao;

import sd.signal.domain.SignalObjectType;


public class SignalObjectTypeEditor extends DictionaryPropertyEditor<SignalObjectType> {

	public SignalObjectTypeEditor(SignalObjectTypeDao signalObjectTypeDao) {
		super(signalObjectTypeDao);
	}
	
}