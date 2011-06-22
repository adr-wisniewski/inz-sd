package servicedesk.core.base.signal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.base.signal.dao.SignalObjectTypeDao;
import servicedesk.core.base.signal.dao.SignalSignificanceTypeDao;
import servicedesk.core.base.signal.dao.SignalTypeDao;
import servicedesk.core.base.signal.domain.SignalObjectType;
import servicedesk.core.base.signal.domain.SignalSignificanceType;
import servicedesk.core.base.signal.domain.SignalType;

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
