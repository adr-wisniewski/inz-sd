package servicedesk.scm.service;

import org.springframework.beans.factory.annotation.Autowired;

import servicedesk.scm.dao.ServiceDao;
import servicedesk.scm.domain.Service;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceDao serviceDao;
	
	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public Service get(Integer serviceId) {
		return serviceDao.get(serviceId);
	}

}
