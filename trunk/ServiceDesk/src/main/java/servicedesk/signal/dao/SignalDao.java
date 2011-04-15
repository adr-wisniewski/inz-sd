package servicedesk.signal.dao;

import java.util.List;

import servicedesk.domain.Employee;
import servicedesk.signal.domain.Signal;
import servicedesk.signal.domain.SignalGenerator;

public interface SignalDao {
	public List<Signal> generateSignals(SignalGenerator generator);
	
	public void save(Signal signal);
	
	public List<Signal> getAll();

	public List<Signal> fetchSignalsToSendEmail();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
