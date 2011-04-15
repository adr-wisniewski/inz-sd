package servicedesk.signal.editor;

import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.signal.dao.SignalTypeDao;
import servicedesk.signal.domain.SignalType;

public class SignalTypeEditor extends DictionaryPropertyEditor<SignalType> {

	public SignalTypeEditor(SignalTypeDao signalTypeDao) {
		super(signalTypeDao);
	}
	
}