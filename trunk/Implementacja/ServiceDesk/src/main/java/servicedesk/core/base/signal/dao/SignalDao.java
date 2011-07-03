package servicedesk.core.base.signal.dao;

import java.util.List;

import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.signal.domain.Signal;
import servicedesk.core.base.signal.domain.SignalGenerator;

public interface SignalDao {
	public List<Signal> generateSignals(SignalGenerator generator);
	
	public void save(Signal signal);
	
	public List<Signal> getAll();

	public List<Signal> fetchSignalsToSendEmail();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
