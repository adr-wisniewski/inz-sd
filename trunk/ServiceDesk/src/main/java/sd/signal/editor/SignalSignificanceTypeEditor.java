package sd.signal.editor;

import sd.dictionary.DictionaryPropertyEditor;
import sd.signal.dao.SignalSignificanceTypeDao;
import sd.signal.domain.SignalSignificanceType;


public class SignalSignificanceTypeEditor extends DictionaryPropertyEditor<SignalSignificanceType> {

	public SignalSignificanceTypeEditor(SignalSignificanceTypeDao signalSignificanceType) {
		super(signalSignificanceType);
	}
	
}
