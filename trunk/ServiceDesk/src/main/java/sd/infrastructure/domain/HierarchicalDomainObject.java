package sd.infrastructure.domain;

import java.io.Serializable;

/**
 * 
 * @author PKalanski
 *
 * Interfejs dla obiektow tworzacych hierarchie
 */
public interface HierarchicalDomainObject<Id extends Serializable> extends DomainObject<Id> {
	/**
	 * @return unikalny identyfikator elementu hierarchii
	 */
	public Id getParentId();
        
	/**
	 * 
	 * @return nazwa elementu
	 */
	public String getName();
}
