package servicedesk.core.base.signal.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.signal.dao.SignalTypeDao;
import servicedesk.core.base.signal.domain.SignalType;

public class SignalTypeEditor extends DictionaryPropertyEditor<SignalType> {

	public SignalTypeEditor(SignalTypeDao signalTypeDao) {
		super(signalTypeDao);
	}
	
}