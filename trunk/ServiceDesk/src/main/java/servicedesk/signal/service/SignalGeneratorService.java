package servicedesk.signal.service;

import java.util.List;

import servicedesk.signal.domain.Signal;
import servicedesk.signal.domain.SignalGenerator;
import servicedesk.signal.domain.SignalReceiverType;
import servicedesk.signal.domain.SignalType;


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
