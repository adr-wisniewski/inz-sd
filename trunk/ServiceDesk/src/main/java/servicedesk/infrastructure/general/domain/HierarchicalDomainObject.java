package servicedesk.infrastructure.general.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * @param <Id> 
 * @author PKalanski
 *
 * Interfejs dla obiektow tworzacych hierarchie
 */
public interface HierarchicalDomainObject<Id extends Serializable> extends NamedDomainObject<Id> {
	/**
	 * @return obiekt rodzica
	 */
        public HierarchicalDomainObject<Id> getParent();
        
        /**
	 * @return kolekcja obiektów potomnych
	 */
        public Collection<? extends HierarchicalDomainObject<Id>>  getChildren();
}
