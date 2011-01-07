package sd.signal.dao;

import sd.infrastructure.dao.DictionaryDao;
import sd.signal.domain.SignalType;

public interface SignalTypeDao extends DictionaryDao<SignalType, Integer> {
	public void save(SignalType signalType);
}
