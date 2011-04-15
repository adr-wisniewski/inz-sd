package servicedesk.signal.editor;

import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.signal.dao.SignalSignificanceTypeDao;
import servicedesk.signal.domain.SignalSignificanceType;


public class SignalSignificanceTypeEditor extends DictionaryPropertyEditor<SignalSignificanceType> {

	public SignalSignificanceTypeEditor(SignalSignificanceTypeDao signalSignificanceType) {
		super(signalSignificanceType);
	}
	
}
