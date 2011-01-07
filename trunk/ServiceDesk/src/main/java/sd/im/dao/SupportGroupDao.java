package sd.im.dao;

import java.util.List;

import sd.im.domain.SupportGroup;

public interface SupportGroupDao {
	/**
	 * 
	 * @param id identyfikator grupy
	 * @return zwraca grupe po id
	 */
	public SupportGroup findById(Integer id);
	
	/**
	 * 
	 * @return zwraca wszystkei grupy
	 */
	public List<SupportGroup> fetchAll();
}
