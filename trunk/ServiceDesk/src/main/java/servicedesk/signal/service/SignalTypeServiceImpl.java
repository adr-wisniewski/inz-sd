package servicedesk.signal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.signal.dao.SignalObjectTypeDao;
import servicedesk.signal.dao.SignalSignificanceTypeDao;
import servicedesk.signal.dao.SignalTypeDao;
import servicedesk.signal.domain.SignalObjectType;
import servicedesk.signal.domain.SignalSignificanceType;
import servicedesk.signal.domain.SignalType;

@Service
@Transactional
public class SignalTypeServiceImpl implements SignalTypeService {
	
	@Autowired
	private SignalTypeDao signalTypeDao;
	@Autowired
	private SignalObjectTypeDao signalObjectTypeDao;
	@Autowired
	private SignalSignificanceTypeDao signalSignificanceTypeDao;
	
	public void setSignalTypeDao(SignalTypeDao signalTypeDao) {
		this.signalTypeDao = signalTypeDao;
	}

	public List<SignalType> getAll() {
		return signalTypeDao.getAll();
	}

	public void edit(SignalType signalType) {
		signalTypeDao.save(signalType);
	}

	public void add(SignalType signalType) {
		signalTypeDao.save(signalType);
	}

	public List<SignalObjectType> getAllObjectTypes() {
		return signalObjectTypeDao.getAll();
	}

	public List<SignalSignificanceType> getAllSignificanceTypes() {
		return signalSignificanceTypeDao.getAll();
	}

}
