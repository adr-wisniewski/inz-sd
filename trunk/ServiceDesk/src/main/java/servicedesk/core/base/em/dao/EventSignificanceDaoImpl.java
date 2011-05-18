package servicedesk.core.base.em.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.base.em.domain.EventSignificance;

@Repository
@Transactional
public class EventSignificanceDaoImpl extends GenericHibernateDao<EventSignificance, String> implements EventSignificanceDao {

}
