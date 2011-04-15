package servicedesk.signal.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.signal.domain.SignalSignificanceType;

@Repository
@Transactional
public class SignalSignificanceTypeDaoImpl extends GenericHibernateDao<SignalSignificanceType,String> implements SignalSignificanceTypeDao {

}
