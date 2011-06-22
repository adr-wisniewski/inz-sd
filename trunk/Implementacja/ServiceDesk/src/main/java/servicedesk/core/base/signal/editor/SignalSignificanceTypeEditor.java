package servicedesk.core.base.signal.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.signal.dao.SignalSignificanceTypeDao;
import servicedesk.core.base.signal.domain.SignalSignificanceType;


public class SignalSignificanceTypeEditor extends DictionaryPropertyEditor<SignalSignificanceType> {

	public SignalSignificanceTypeEditor(SignalSignificanceTypeDao signalSignificanceType) {
		super(signalSignificanceType);
	}
	
}
