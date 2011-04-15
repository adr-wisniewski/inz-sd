package servicedesk.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.signal.domain.SignalObjectType;

@Repository
@Transactional
public class SignalObjectTypeDaoImpl extends GenericHibernateDao<SignalObjectType,String> implements SignalObjectTypeDao {

}
