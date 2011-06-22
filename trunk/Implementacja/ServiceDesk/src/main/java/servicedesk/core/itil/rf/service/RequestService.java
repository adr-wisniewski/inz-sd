package servicedesk.core.itil.rf.service;

import java.util.List;

import servicedesk.core.base.comment.domain.Comment;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.rf.app.RequestSearchCriteria;
import servicedesk.core.itil.rf.domain.RequestCategory;
import servicedesk.core.itil.rf.domain.RequestPriority;
import servicedesk.core.itil.rf.domain.RequestStatus;
import servicedesk.core.itil.rf.domain.ServiceRequest;

public interface RequestService {
	/**
	 * @param id identyfikator żądania
	 * @return żadanie o podanym id
	 */
	public ServiceRequest getById(Integer id);
	
	/**
	 * Dodaje nowe żądanie
	 * @param request żądanie
	 */
	public void add(ServiceRequest request);
	
	/**
	 * Zapisuje żądanie
	 * @param request żądanie
	 */
	public void edit(ServiceRequest request);
	
	/**
	 * @return zwraca listę kategorii
	 */
	public List<RequestCategory> getAllCategories();

	/**
	 * Wyszukuje żądań spełniających podane kryterium
	 * @param searchCriteria kryterium wyszukiwania
	 * @return lista żądań spełniających kryterium
	 */
	public List<ServiceRequest> search(RequestSearchCriteria searchCriteria);
	
	/**
	 * 
	 * @return zwraca wszystkie mozliwe priorytety
	 */
	public List<RequestPriority> getAllPriorities();
	
	/**
	 * 
	 * @return zwraca wszystkie mozliwe statusy
	 */
	public List<RequestStatus> getAllStatuses();
	
	/**
	 * Dodaje nowy komentarz dla żądania
	 * @param request żądanie
	 * @param comment komentarz
	 */
	public void addComment(ServiceRequest request, Comment comment);
	
	/**
	 * 
	 * @return zwraca wszystkie grupy wsparcia
	 */
	public List<SupportGroup> getAllGroups();
	
}
