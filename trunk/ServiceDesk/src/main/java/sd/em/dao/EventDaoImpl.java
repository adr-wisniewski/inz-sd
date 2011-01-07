package sd.em.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.em.app.EventSearchCriteria;
import sd.em.domain.Event;

@Repository
@Transactional
public class EventDaoImpl extends GenericHibernateDao<Event> implements EventDao {

	public EventDaoImpl() {
		super(Event.class);
	}

	public Event getById(Integer id) {
		return findById(id);
	}

	public List<Event> search(EventSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}

}
