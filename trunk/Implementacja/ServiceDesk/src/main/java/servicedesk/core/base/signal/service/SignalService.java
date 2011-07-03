package servicedesk.core.base.signal.service;

import java.util.List;

import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.signal.domain.Signal;

public interface SignalService {
	public void sendEmailForSignals();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
