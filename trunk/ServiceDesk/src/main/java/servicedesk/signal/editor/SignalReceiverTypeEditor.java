package servicedesk.signal.editor;

import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.signal.dao.SignalReceiverTypeDao;
import servicedesk.signal.domain.SignalReceiverType;

public class SignalReceiverTypeEditor extends DictionaryPropertyEditor<SignalReceiverType> {

	public SignalReceiverTypeEditor(SignalReceiverTypeDao signalReceiverTypeDao) {
		super(signalReceiverTypeDao);
	}
	
}
