package servicedesk.infrastructure.general.dao;

import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;
import java.io.Serializable;


// TODO: cleanup
public interface HierarchyDao<Type extends HierarchicalDomainObject<Id>, Id extends Serializable > extends GetDao<Type, Id> {
        public Class<Id> getIdClass(); // TODO: cleanup(move up?)
}
