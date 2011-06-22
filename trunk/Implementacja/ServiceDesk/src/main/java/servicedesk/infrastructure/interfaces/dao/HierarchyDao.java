package servicedesk.infrastructure.interfaces.dao;

import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;
import java.io.Serializable;

public interface HierarchyDao<Type extends HierarchicalDomainObject<Id>, Id extends Serializable > extends Dao<Type, Id> {
  
}
