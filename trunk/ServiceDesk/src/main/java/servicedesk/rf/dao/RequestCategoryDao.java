package servicedesk.rf.dao;

import servicedesk.infrastructure.general.dao.DictionaryDao;
import servicedesk.rf.domain.RequestCategory;
import servicedesk.infrastructure.general.dao.HierarchyDao;

public interface RequestCategoryDao extends DictionaryDao<RequestCategory, String>, HierarchyDao<RequestCategory,String> {

}
