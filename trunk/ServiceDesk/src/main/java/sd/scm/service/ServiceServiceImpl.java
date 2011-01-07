package sd.scm.service;

import org.springframework.beans.factory.annotation.Autowired;

import sd.scm.dao.ServiceDao;
import sd.scm.domain.Service;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceDao serviceDao;
	
	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public Service findById(Integer serviceId) {
		return serviceDao.findById(serviceId);
	}

}
