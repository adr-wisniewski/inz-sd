package servicedesk.signal.dao;

import servicedesk.infrastructure.dao.DictionaryDao;
import servicedesk.signal.domain.SignalType;

public interface SignalTypeDao extends DictionaryDao<SignalType, Integer> {
	public void save(SignalType signalType);
}
