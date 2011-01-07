package sd.signal.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.signal.domain.SignalSignificanceType;

@Repository
@Transactional
public class SignalSignificanceTypeDaoImpl extends GenericHibernateDao<SignalSignificanceType> implements SignalSignificanceTypeDao {

	public SignalSignificanceTypeDaoImpl() {
		super(SignalSignificanceType.class);
	}

}
