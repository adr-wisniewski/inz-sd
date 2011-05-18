package servicedesk.core.base.signal.service;

import java.util.List;

import servicedesk.core.base.signal.domain.SignalObjectType;
import servicedesk.core.base.signal.domain.SignalSignificanceType;
import servicedesk.core.base.signal.domain.SignalType;

public interface SignalTypeService {
	public List<SignalType> getAll();

	public void edit(SignalType signalType);

	public void add(SignalType signalType);

	public List<SignalObjectType> getAllObjectTypes();

	public List<SignalSignificanceType> getAllSignificanceTypes();
}
