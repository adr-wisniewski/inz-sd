package servicedesk.signal.service;

import java.util.List;

import servicedesk.signal.domain.SignalObjectType;
import servicedesk.signal.domain.SignalSignificanceType;
import servicedesk.signal.domain.SignalType;

public interface SignalTypeService {
	public List<SignalType> getAll();

	public void edit(SignalType signalType);

	public void add(SignalType signalType);

	public List<SignalObjectType> getAllObjectTypes();

	public List<SignalSignificanceType> getAllSignificanceTypes();
}
