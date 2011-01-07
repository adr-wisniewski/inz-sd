package sd.signal.editor;

import sd.dictionary.DictionaryPropertyEditor;
import sd.signal.dao.SignalReceiverTypeDao;
import sd.signal.domain.SignalReceiverType;

public class SignalReceiverTypeEditor extends DictionaryPropertyEditor<SignalReceiverType> {

	public SignalReceiverTypeEditor(SignalReceiverTypeDao signalReceiverTypeDao) {
		super(signalReceiverTypeDao);
	}
	
}
