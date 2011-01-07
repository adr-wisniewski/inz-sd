package sd.rf.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.event.service.GenericEventService;
import sd.im.dao.SupportGroupDao;
import sd.im.domain.SupportGroup;
import sd.rf.app.RequestSearchCriteria;
import sd.rf.dao.RequestCategoryDao;
import sd.rf.dao.RequestDao;
import sd.rf.dao.RequestPriorityDao;
import sd.rf.dao.RequestStatusDao;
import sd.rf.domain.RequestCategory;
import sd.rf.domain.RequestPriority;
import sd.rf.domain.RequestStatus;
import sd.rf.domain.ServiceRequest;

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
		return requestCategoryDao.fetchAll();
	}


	public List<RequestPriority> getAllPriorities() {
		return requestPriorityDao.fetchAll();
	}

	public List<RequestStatus> getAllStatuses() {
		return requestStatusDao.fetchAll();
	}

	public List<SupportGroup> getAllGroups() {
		return supportGroupDao.fetchAll();
	}
}
