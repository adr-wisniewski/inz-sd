package servicedesk.em.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.em.app.EventSearchCriteria;
import servicedesk.em.domain.Event;

@Repository
@Transactional
public class EventDaoImpl extends GenericHibernateDao<Event, Integer> implements EventDao {

        @Override
	public List<Event> search(EventSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}

}
