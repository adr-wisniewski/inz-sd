package servicedesk.infrastructure.dao;

import servicedesk.infrastructure.domain.HierarchicalDomainObject;
import java.io.Serializable;
import java.util.List;

public interface HierarchyDao<Type extends HierarchicalDomainObject<Id>, Id extends Serializable > extends Dao<Type, Id> {
	public List<Type> getAll();
        public Class<Id> getIdClass();
}
