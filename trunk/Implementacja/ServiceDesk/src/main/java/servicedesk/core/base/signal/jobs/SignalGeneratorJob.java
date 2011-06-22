package servicedesk.core.base.signal.jobs;

import org.springframework.beans.factory.annotation.Autowired;

import servicedesk.core.base.signal.service.SignalGeneratorService;

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
