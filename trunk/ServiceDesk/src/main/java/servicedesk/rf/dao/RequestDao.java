package servicedesk.rf.dao;

import java.util.List;

import servicedesk.event.dao.IEventDao;
import servicedesk.rf.app.RequestSearchCriteria;
import servicedesk.rf.domain.ServiceRequest;

public interface RequestDao extends IEventDao<ServiceRequest>{
	/**
	 * Zapisuje żądanie
	 * @param request żądanie
	 */
	public void save(ServiceRequest request);
	
	/**
	 * @param id identyfikator żądania
	 * @return zwraca żądanie o podanym id
	 */
	public ServiceRequest get(Integer id);

	/**
	 * Wyszukuje żądań spełniających podane kryterium
	 * @param searchCriteria kryterium wyszukiwania
	 * @return lista żądań spełniających kryterium
	 */
	public List<ServiceRequest> search(RequestSearchCriteria searchCriteria);
}
