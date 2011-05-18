package servicedesk.core.base.signal.service;

import java.util.List;

import servicedesk.core.base.signal.domain.Signal;
import servicedesk.core.base.signal.domain.SignalGenerator;
import servicedesk.core.base.signal.domain.SignalReceiverType;
import servicedesk.core.base.signal.domain.SignalType;


public interface SignalGeneratorService {
	public void generateSignals();
	
	public List<SignalGenerator> getReadyGenerators();
	
	public List<Signal> getSignals(SignalGenerator g);
	
	public List<SignalGenerator> getAll();

	public SignalGenerator getById(Integer generatorId);

	public void add(SignalGenerator generator);

	public void edit(SignalGenerator generator);

	public List<SignalType> getAllSignalTypes();

	public List<SignalReceiverType> getAllSignalReceiverTypes();
}
