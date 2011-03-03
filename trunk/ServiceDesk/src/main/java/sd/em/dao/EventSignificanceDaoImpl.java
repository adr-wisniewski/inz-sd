package sd.em.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.em.domain.EventSignificance;

@Repository
@Transactional
public class EventSignificanceDaoImpl extends GenericHibernateDao<EventSignificance, String> implements EventSignificanceDao {

}
