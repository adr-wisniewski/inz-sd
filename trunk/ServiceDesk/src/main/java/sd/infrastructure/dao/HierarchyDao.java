package sd.infrastructure.dao;

import sd.infrastructure.domain.HierarchicalDomainObject;
import java.io.Serializable;
import java.util.List;

public interface HierarchyDao<T extends HierarchicalDomainObject<Id>, Id extends Serializable > extends Dao<T, Id> {
	public List<T> getAll();
	public T get(Id id);
}
