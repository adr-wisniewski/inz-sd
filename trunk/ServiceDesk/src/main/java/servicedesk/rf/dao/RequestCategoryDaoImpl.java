package servicedesk.rf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.rf.domain.RequestCategory;

@Repository
@Transactional
public class RequestCategoryDaoImpl extends GenericHibernateDao<RequestCategory,String> implements RequestCategoryDao {

}
