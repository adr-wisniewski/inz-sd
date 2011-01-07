package sd.rf.dao;

import java.util.List;

import sd.event.dao.IEventDao;
import sd.rf.app.RequestSearchCriteria;
import sd.rf.domain.ServiceRequest;

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
