package sd.rf.dao;

import sd.infrastructure.dao.DictionaryDao;
import sd.rf.domain.RequestCategory;
import sd.infrastructure.dao.HierarchyDao;

public interface RequestCategoryDao extends DictionaryDao<RequestCategory, String>, HierarchyDao<RequestCategory,String> {

}
