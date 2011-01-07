package sd.signal.service;

import java.util.List;

import sd.domain.Employee;
import sd.signal.domain.Signal;

public interface SignalService {
	public void sendEmailForSignals();

	public List<Signal> getSignalsForEmployee(Employee employee);
}
