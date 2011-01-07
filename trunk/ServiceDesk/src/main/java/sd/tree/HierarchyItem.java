package sd.tree;

/**
 * 
 * @author PKalanski
 *
 * Interfejs dla obiektow tworzacych hierarchie
 */
public interface HierarchyItem {
	/**
	 * @return unikalny identyfikator elementu hierarchii
	 */
	public String getId();
	/**
	 * @return unikalny identyfikator elementu hierarchii
	 */
	public String getParentId();
	/**
	 * 
	 * @return nazwa elementu
	 */
	public String getName();
}
