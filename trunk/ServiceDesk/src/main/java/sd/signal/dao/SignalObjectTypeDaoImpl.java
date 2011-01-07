package sd.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.signal.domain.SignalObjectType;

@Repository
@Transactional
public class SignalObjectTypeDaoImpl extends GenericHibernateDao<SignalObjectType> implements SignalObjectTypeDao {

	public SignalObjectTypeDaoImpl() {
		super(SignalObjectType.class);
	}
}
