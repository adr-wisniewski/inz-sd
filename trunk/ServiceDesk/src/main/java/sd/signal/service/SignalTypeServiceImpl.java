package sd.signal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.signal.dao.SignalObjectTypeDao;
import sd.signal.dao.SignalSignificanceTypeDao;
import sd.signal.dao.SignalTypeDao;
import sd.signal.domain.SignalObjectType;
import sd.signal.domain.SignalSignificanceType;
import sd.signal.domain.SignalType;

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
