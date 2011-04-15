package servicedesk.em.service;

import java.util.List;

import servicedesk.em.app.EventSearchCriteria;
import servicedesk.em.domain.Event;
import servicedesk.em.domain.EventSignificance;

public interface EventService {
	public void add(Event event, boolean incident);
	
	public void addAll(List<Event> event);
	
	public List<Event> search(EventSearchCriteria searchCriteria);

	public List<EventSignificance> getAllSignificanceTypes();
	
	public Event get(Integer id);
}
