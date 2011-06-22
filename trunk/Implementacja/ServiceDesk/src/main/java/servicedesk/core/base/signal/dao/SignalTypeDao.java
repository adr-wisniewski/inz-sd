package servicedesk.core.base.signal.dao;

import servicedesk.infrastructure.interfaces.dao.DictionaryDao;
import servicedesk.core.base.signal.domain.SignalType;

public interface SignalTypeDao extends DictionaryDao<SignalType, Integer> {
	public void save(SignalType signalType);
}
