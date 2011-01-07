package sd.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.signal.domain.SignalGenerator;

@Repository
@Transactional
public class SignalGeneratorDaoImpl extends GenericHibernateDao<SignalGenerator,Integer> implements SignalGeneratorDao {

	public SignalGeneratorDaoImpl() {
		super(SignalGenerator.class, Integer.class);
	}
}
