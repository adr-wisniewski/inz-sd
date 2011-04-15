package servicedesk.rf.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.event.service.GenericEventService;
import servicedesk.im.dao.SupportGroupDao;
import servicedesk.im.domain.SupportGroup;
import servicedesk.rf.app.RequestSearchCriteria;
import servicedesk.rf.dao.RequestCategoryDao;
import servicedesk.rf.dao.RequestDao;
import servicedesk.rf.dao.RequestPriorityDao;
import servicedesk.rf.dao.RequestStatusDao;
import servicedesk.rf.domain.RequestCategory;
import servicedesk.rf.domain.RequestPriority;
import servicedesk.rf.domain.RequestStatus;
import servicedesk.rf.domain.ServiceRequest;

@Service
@Transactional
public class RequestServiceImpl extends GenericEventService<ServiceRequest, RequestDao, RequestSearchCriteria> implements RequestService {
	@Autowired
	public void setRequestDao(RequestDao requestDao) {
		this.eventDao = requestDao;
	}
	
	@Autowired
	private RequestCategoryDao requestCategoryDao;
	
	public void setRequestCategoryDao(RequestCategoryDao requestCategoryDao) {
		this.requestCategoryDao = requestCategoryDao;
	}
	
	@Autowired
	private RequestPriorityDao requestPriorityDao;
	
	public void setRequestPriorityDao(RequestPriorityDao requestPriorityDao) {
		this.requestPriorityDao = requestPriorityDao;
	}
	
	@Autowired
	private RequestStatusDao requestStatusDao;
	
	public void setRequestStatusDao(RequestStatusDao requestStatusDao) {
		this.requestStatusDao = requestStatusDao;
	}
	
	@Autowired
	private SupportGroupDao supportGroupDao;
	
	public void setSupportGroupDao(SupportGroupDao supportGroupDao) {
		this.supportGroupDao = supportGroupDao;
	}

	public void add(ServiceRequest request) {
		request.setStatus(RequestStatus.OPEN);
		super.add(request);
	}

	public void edit(ServiceRequest request) {
		if(request.getStatus().equals(RequestStatus.CLOSED)) {
			request.setClosureDate(new Date());
		}
		
		request.refreshTargetResolutionDate();
		
		super.edit(request);
	}

	public List<RequestCategory> getAllCategories() {
		return requestCategoryDao.getAll();
	}


	public List<RequestPriority> getAllPriorities() {
		return requestPriorityDao.getAll();
	}

	public List<RequestStatus> getAllStatuses() {
		return requestStatusDao.getAll();
	}

	public List<SupportGroup> getAllGroups() {
		return supportGroupDao.getAll();
	}
}
