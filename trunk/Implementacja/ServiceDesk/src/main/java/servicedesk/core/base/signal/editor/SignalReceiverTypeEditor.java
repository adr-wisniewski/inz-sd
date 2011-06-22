package servicedesk.core.base.signal.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.signal.dao.SignalReceiverTypeDao;
import servicedesk.core.base.signal.domain.SignalReceiverType;

public class SignalReceiverTypeEditor extends DictionaryPropertyEditor<SignalReceiverType> {

	public SignalReceiverTypeEditor(SignalReceiverTypeDao signalReceiverTypeDao) {
		super(signalReceiverTypeDao);
	}
	
}
