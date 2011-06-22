package servicedesk.core.base.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.base.signal.domain.SignalObjectType;

@Repository
@Transactional
public class SignalObjectTypeDaoImpl extends GenericHibernateDao<SignalObjectType,String> implements SignalObjectTypeDao {

}
