package sd.signal.dao;

import sd.dictionary.DictionaryPropertyDao;
import sd.signal.domain.SignalType;

public interface SignalTypeDao extends DictionaryPropertyDao<SignalType> {
	public void save(SignalType signalType);
}
