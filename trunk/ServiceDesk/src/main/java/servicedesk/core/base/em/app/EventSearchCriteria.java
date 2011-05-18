package servicedesk.core.base.em.app;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import servicedesk.core.base.em.domain.Event;
import servicedesk.core.base.em.domain.EventCategory;
import servicedesk.core.base.em.domain.EventSignificance;

public class EventSearchCriteria implements SearchCriteria<Event> {
	private String subject;
	
	private Integer id;
	
	private EventSignificance significance;
	
	private EventCategory category;
	
	private Date startCreationDate;
	
	private Date endCreationDate;
	
	private Date startEventDate;
	
	private Date endEventDate;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EventSignificance getSignificance() {
		return significance;
	}
	
	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
	}

	public void setSignificance(EventSignificance significance) {
		this.significance = significance;
	}
	
	public Date getStartCreationDate() {
		return startCreationDate;
	}

	public void setStartCreationDate(Date startCreationDate) {
		this.startCreationDate = startCreationDate;
	}

	public Date getEndCreationDate() {
		return endCreationDate;
	}

	public void setEndCreationDate(Date endCreationDate) {
		this.endCreationDate = endCreationDate;
	}

	public Date getStartEventDate() {
		return startEventDate;
	}

	public void setStartEventDate(Date startEventDate) {
		this.startEventDate = startEventDate;
	}

	public Date getEndEventDate() {
		return endEventDate;
	}

	public void setEndEventDate(Date endEventDate) {
		this.endEventDate = endEventDate;
	}

	public String buildCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(subject != null) criteria.add(Restrictions.like("subject", "%" + subject + "%"));
		if(significance != null) criteria.add(Restrictions.eq("significance", significance));
		if(category != null) criteria.add(Restrictions.eq("category", category));
		if(startCreationDate != null) criteria.add(Restrictions.ge("creationDate", startCreationDate));
		if(endCreationDate != null) criteria.add(Restrictions.le("creationDate", endCreationDate));
		if(startEventDate != null) criteria.add(Restrictions.ge("eventDate", startEventDate));
		if(endEventDate != null) criteria.add(Restrictions.le("eventDate", endEventDate));
	}

	public boolean match(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

}
