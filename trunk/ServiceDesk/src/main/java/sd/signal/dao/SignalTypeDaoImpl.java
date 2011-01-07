package sd.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.signal.domain.SignalType;

@Repository
@Transactional
public class SignalTypeDaoImpl extends GenericHibernateDao<SignalType,Integer> implements SignalTypeDao {
    public SignalTypeDaoImpl() {
        super(SignalType.class, Integer.class);
    }
}
