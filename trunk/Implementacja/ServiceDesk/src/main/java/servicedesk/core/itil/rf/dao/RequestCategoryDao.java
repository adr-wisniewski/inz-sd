package servicedesk.core.itil.rf.dao;

import servicedesk.infrastructure.interfaces.dao.DictionaryDao;
import servicedesk.core.itil.rf.domain.RequestCategory;
import servicedesk.infrastructure.interfaces.dao.HierarchyDao;

public interface RequestCategoryDao extends DictionaryDao<RequestCategory, String>, HierarchyDao<RequestCategory,String> {

}
