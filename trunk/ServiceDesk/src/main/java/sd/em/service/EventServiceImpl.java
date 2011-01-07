package sd.em.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.em.app.EventSearchCriteria;
import sd.em.dao.EventDao;
import sd.em.dao.EventSignificanceDao;
import sd.em.domain.Event;
import sd.em.domain.EventSignificance;
import sd.im.domain.Incident;
import sd.im.domain.IncidentSource;
import sd.im.service.IncidentService;
import sd.service.EmployeeService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private static Logger logger = Logger.getLogger(EventServiceImpl.class);
    @Autowired
    private EventDao eventDao;
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private EventSignificanceDao eventTypeDao;
    @Autowired
    private EmployeeService employeeService;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setEventSignificanceDao(EventSignificanceDao eventTypeDao) {
        this.eventTypeDao = eventTypeDao;
    }

    public void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void add(Event event, boolean addIncident) {
        if (addIncident) {
            Incident incident = new Incident();
            incident.setSubject(event.getSubject());
            incident.setDescription("Event");
            incident.setAuthor(employeeService.getSystem());
            incident.setSource(IncidentSource.EVENT);
            incidentService.add(incident);
            event.setIncident(incident);
        }
        event.setCreationDate(new Date());
        eventDao.save(event);
    }

    @Override
    public void addAll(List<Event> event) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Event> search(EventSearchCriteria searchCriteria) {
        return eventDao.search(searchCriteria);
    }

    @Override
    public List<EventSignificance> getAllSignificanceTypes() {
        return eventTypeDao.getAll();
    }

    @Override
    public Event get(Integer id) {
        return eventDao.get(id);
    }
}
