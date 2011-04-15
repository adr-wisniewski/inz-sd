package servicedesk.em.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.em.domain.EventSignificance;

@Repository
@Transactional
public class EventSignificanceDaoImpl extends GenericHibernateDao<EventSignificance, String> implements EventSignificanceDao {

}
