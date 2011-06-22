package servicedesk.core.itil.im.dao;

import java.util.List;

import servicedesk.core.itil.im.domain.SupportGroup;

public interface SupportGroupDao {
	/**
	 * 
	 * @param id identyfikator grupy
	 * @return zwraca grupe po id
	 */
	public SupportGroup get(Integer id);
	
	/**
	 * 
	 * @return zwraca wszystkei grupy
	 */
	public List<SupportGroup> getAll();
}
