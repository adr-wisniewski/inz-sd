package sd.event.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sd.app.SearchCriteria;
import sd.domain.Comment;
import sd.event.dao.IEventDao;
import sd.event.domain.IEvent;
import sd.service.EmployeeService;

@Transactional
public class GenericEventService<E extends IEvent, EDAO extends IEventDao<E>, ESC extends SearchCriteria<E>> {
	Logger logger = Logger.getLogger(GenericEventService.class);
	
	@Autowired
	protected EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/** 
	 * 
	 */
	protected EDAO eventDao;

	/**
	 * 
	 */
	public List<E> search(ESC searchCriteria) {
		return eventDao.search(searchCriteria);
	}

	/** 
	 * 
	 */
	public void add(E event) {	
		event.setCreationDate(new Date());			
		if(event.getAuthor() == null) {			
			event.setAuthor(employeeService.getCurrentUser());
		}	
		eventDao.save(event);	
	}

	/** 
	 * 
	 */
	public void edit(E event) {
		eventDao.save(event);
	}

	/** 
	 * 
	 */
	public E getById(Integer eventId) {
		return eventDao.getById(eventId);
	}

	/** 
	 * 
	 */
	public void addComment(E event, Comment comment) {
		event.addComment(comment);
		comment.setCreationDate(new Date());
		comment.setAuthor(employeeService.getCurrentUser());
		eventDao.save(event);
	}

}