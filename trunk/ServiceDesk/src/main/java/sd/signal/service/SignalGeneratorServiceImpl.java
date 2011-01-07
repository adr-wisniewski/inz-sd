package sd.signal.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.signal.dao.SignalDao;
import sd.signal.dao.SignalGeneratorDao;
import sd.signal.dao.SignalReceiverTypeDao;
import sd.signal.dao.SignalTypeDao;
import sd.signal.domain.Signal;
import sd.signal.domain.SignalGenerator;
import sd.signal.domain.SignalReceiverType;
import sd.signal.domain.SignalType;

@Service
@Transactional
public class SignalGeneratorServiceImpl implements SignalGeneratorService {
	
	@Autowired
	private SignalGeneratorDao signalGeneratorDao;
	@Autowired
	private SignalDao signalDao;
	@Autowired
	private SignalTypeDao signalTypeDao;
	@Autowired
	private SignalReceiverTypeDao signalReceiverTypeDao;
	
	public void setSignalGeneratorDao(SignalGeneratorDao signalGeneratorDao) {
		this.signalGeneratorDao = signalGeneratorDao;
	}
	
	public void setSignalDao(SignalDao signalDao) {
		this.signalDao = signalDao;
	}

	public List<SignalGenerator> getReadyGenerators() {
		List<SignalGenerator> result = new LinkedList<SignalGenerator>();
		for(SignalGenerator g : this.signalGeneratorDao.fetchAll()) {	
			if(g.isReady()) {
				result.add(g);
			}
		}
		
		return result;
	}
	
	public void setSignalTypeDao(SignalTypeDao signalTypeDao) {
		this.signalTypeDao = signalTypeDao;
	}

	public void setSignalReceiverTypeDao(SignalReceiverTypeDao signalReceiverTypeDao) {
		this.signalReceiverTypeDao = signalReceiverTypeDao;
	}

	public void generateSignals() {
		for(SignalGenerator g : this.getReadyGenerators()) {	
			this.generateSignals(g);
		}
	}
	
	private void generateSignals(SignalGenerator g) {
		try {
			for(Signal s : getSignals(g)) {
				signalDao.save(s);
			}
			g.setLastRunDate(new Date());
			g.setLastRunStatus(true);
		}
		catch(RuntimeException e) {
			g.setErrorMessage(e.getMessage());
			throw e;
		}
		finally {
			signalGeneratorDao.save(g);
		}
	}

	public List<SignalGenerator> fetchAll() {
		return signalGeneratorDao.fetchAll();
	}

	public SignalGenerator getById(Integer generatorId) {
		return signalGeneratorDao.findById(generatorId);
	}

	public void add(SignalGenerator generator) {
		generator.setLastRunDate(new Date());
		generator.setSelectStatement("o.*, e.employee_id");
		signalGeneratorDao.save(generator);
	}

	public void edit(SignalGenerator generator) {
		signalGeneratorDao.save(generator);
	}

	public List<SignalReceiverType> getAllSignalReceiverTypes() {
		return signalReceiverTypeDao.fetchAll();
	}

	public List<SignalType> getAllSignalTypes() {
		return signalTypeDao.fetchAll();
	}

	public List<Signal> getSignals(SignalGenerator g) {
		return signalDao.generateSignals(g);
	}
	
}
