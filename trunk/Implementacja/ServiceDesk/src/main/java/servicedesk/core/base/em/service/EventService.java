package servicedesk.core.base.em.service;

import java.util.List;

import servicedesk.core.base.em.app.EventSearchCriteria;
import servicedesk.core.base.em.domain.Event;
import servicedesk.core.base.em.domain.EventSignificance;

public interface EventService {
	public void add(Event event, boolean incident);
	
	public void addAll(List<Event> event);
	
	public List<Event> search(EventSearchCriteria searchCriteria);

	public List<EventSignificance> getAllSignificanceTypes();
	
	public Event get(Integer id);
}
