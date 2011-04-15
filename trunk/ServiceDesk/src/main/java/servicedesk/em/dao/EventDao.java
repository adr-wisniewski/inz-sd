package servicedesk.em.dao;

import java.util.List;

import servicedesk.em.app.EventSearchCriteria;
import servicedesk.em.domain.Event;

public interface EventDao {
	public Event get(Integer id);
	
	public void save(Event event);

	public List<Event> search(EventSearchCriteria searchCriteria);
}
