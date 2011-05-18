package servicedesk.core.base.em.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.base.em.app.EventSearchCriteria;
import servicedesk.core.base.em.domain.Event;

@Repository
@Transactional
public class EventDaoImpl extends GenericHibernateDao<Event, Integer> implements EventDao {

        @Override
	public List<Event> search(EventSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}

}
