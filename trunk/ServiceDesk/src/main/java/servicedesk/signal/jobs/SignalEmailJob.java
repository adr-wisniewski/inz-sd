package servicedesk.signal.jobs;

import org.springframework.beans.factory.annotation.Autowired;

import servicedesk.signal.service.SignalService;

public class SignalEmailJob extends AbstractJob {
	@Autowired
	private SignalService service;
	
	@Override
	protected void doExecute() {
		service.sendEmailForSignals();
	}
	
}
