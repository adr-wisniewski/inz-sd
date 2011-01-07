package sd.signal.service;

import java.util.List;

import sd.signal.domain.Signal;
import sd.signal.domain.SignalGenerator;
import sd.signal.domain.SignalReceiverType;
import sd.signal.domain.SignalType;


public interface SignalGeneratorService {
	public void generateSignals();
	
	public List<SignalGenerator> getReadyGenerators();
	
	public List<Signal> getSignals(SignalGenerator g);
	
	public List<SignalGenerator> fetchAll();

	public SignalGenerator getById(Integer generatorId);

	public void add(SignalGenerator generator);

	public void edit(SignalGenerator generator);

	public List<SignalType> getAllSignalTypes();

	public List<SignalReceiverType> getAllSignalReceiverTypes();
}
