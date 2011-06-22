package servicedesk.core.itil.rf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.itil.rf.domain.RequestCategory;

@Repository
@Transactional
public class RequestCategoryDaoImpl extends GenericHibernateDao<RequestCategory,String> implements RequestCategoryDao {

}
