package servicedesk.rf.dao;

import servicedesk.infrastructure.dao.DictionaryDao;
import servicedesk.rf.domain.RequestCategory;
import servicedesk.infrastructure.dao.HierarchyDao;

public interface RequestCategoryDao extends DictionaryDao<RequestCategory, String>, HierarchyDao<RequestCategory,String> {

}
