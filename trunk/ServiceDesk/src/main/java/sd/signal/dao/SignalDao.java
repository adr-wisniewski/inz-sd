package sd.signal.dao;

import java.util.List;

import sd.domain.Employee;
import sd.signal.domain.Signal;
import sd.signal.domain.SignalGenerator;

public interface SignalDao {
	public List<Signal> generateSignals(SignalGenerator generator);
	
	public void save(Signal signal);
	
	public List<Signal> getAll();

	public List<Signal> fetchSignalsToSendEmail();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
