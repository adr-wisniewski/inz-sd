package servicedesk.core.base.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.base.signal.domain.SignalGenerator;

@Repository
@Transactional
public class SignalGeneratorDaoImpl extends GenericHibernateDao<SignalGenerator,Integer> implements SignalGeneratorDao {

}
