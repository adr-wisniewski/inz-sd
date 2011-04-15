package servicedesk.signal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.signal.domain.SignalGenerator;

@Repository
@Transactional
public class SignalGeneratorDaoImpl extends GenericHibernateDao<SignalGenerator,Integer> implements SignalGeneratorDao {

}
