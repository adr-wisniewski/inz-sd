package servicedesk.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.signal.domain.SignalReceiverType;

@Repository
@Transactional
public class SignalReceiverTypeDaoImpl extends GenericHibernateDao<SignalReceiverType,String> implements SignalReceiverTypeDao {

}
