package sd.signal.jobs;

import org.springframework.beans.factory.annotation.Autowired;

import sd.signal.service.SignalGeneratorService;

public class SignalGeneratorJob extends AbstractJob {
	@Autowired
	private SignalGeneratorService service;
	
	public void setSignalGeneratorService(SignalGeneratorService signalGeneratorService) {
		this.service = signalGeneratorService;
	}

	@Override
	protected void doExecute() {
		service.generateSignals();
	}
}