package sd.em.dao;

import java.util.List;

import sd.em.app.EventSearchCriteria;
import sd.em.domain.Event;

public interface EventDao {
	public Event getById(Integer id);
	
	public void save(Event event);

	public List<Event> search(EventSearchCriteria searchCriteria);
}
