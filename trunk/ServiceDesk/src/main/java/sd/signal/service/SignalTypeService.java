package sd.signal.service;

import java.util.List;

import sd.signal.domain.SignalObjectType;
import sd.signal.domain.SignalSignificanceType;
import sd.signal.domain.SignalType;

public interface SignalTypeService {
	public List<SignalType> fetchAll();

	public void edit(SignalType signalType);

	public void add(SignalType signalType);

	public List<SignalObjectType> getAllObjectTypes();

	public List<SignalSignificanceType> getAllSignificanceTypes();
}
