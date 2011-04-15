package servicedesk.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.signal.domain.SignalType;

@Repository
@Transactional
public class SignalTypeDaoImpl extends GenericHibernateDao<SignalType,Integer> implements SignalTypeDao {

}
