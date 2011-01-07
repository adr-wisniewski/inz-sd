package sd.signal.editor;

import sd.dictionary.DictionaryPropertyEditor;
import sd.signal.dao.SignalTypeDao;
import sd.signal.domain.SignalType;

public class SignalTypeEditor extends DictionaryPropertyEditor<SignalType> {

	public SignalTypeEditor(SignalTypeDao signalTypeDao) {
		super(signalTypeDao);
	}
	
}