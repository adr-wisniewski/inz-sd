package sd.em.service;

import java.util.List;

import sd.em.app.EventSearchCriteria;
import sd.em.domain.Event;
import sd.em.domain.EventSignificance;

public interface EventService {
	public void add(Event event, boolean incident);
	
	public void addAll(List<Event> event);
	
	public List<Event> search(EventSearchCriteria searchCriteria);

	public List<EventSignificance> getAllSignificanceTypes();
	
	public Event getById(Integer id);
}
