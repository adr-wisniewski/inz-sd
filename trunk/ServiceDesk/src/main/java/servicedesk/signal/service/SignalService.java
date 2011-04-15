package servicedesk.signal.service;

import java.util.List;

import servicedesk.domain.Employee;
import servicedesk.signal.domain.Signal;

public interface SignalService {
	public void sendEmailForSignals();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
