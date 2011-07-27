package servicedesk.core.base.em.dao;

import java.util.List;

import servicedesk.core.base.em.app.EventSearchCriteria;
import servicedesk.core.base.em.domain.Event;

public interface EventDao {
	public Event get(Integer id);
	
	public void save(Event event);

	public List<Event> search(EventSearchCriteria searchCriteria);
}
