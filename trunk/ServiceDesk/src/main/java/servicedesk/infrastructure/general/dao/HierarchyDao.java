package servicedesk.infrastructure.general.dao;

import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;
import java.io.Serializable;

public interface HierarchyDao<Type extends HierarchicalDomainObject<Id>, Id extends Serializable > extends Dao<Type, Id> {
        public Class<Id> getIdClass();
}
