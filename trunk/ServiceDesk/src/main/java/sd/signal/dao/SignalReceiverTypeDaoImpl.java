package sd.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.signal.domain.SignalReceiverType;

@Repository
@Transactional
public class SignalReceiverTypeDaoImpl extends GenericHibernateDao<SignalReceiverType,String> implements SignalReceiverTypeDao {

}
