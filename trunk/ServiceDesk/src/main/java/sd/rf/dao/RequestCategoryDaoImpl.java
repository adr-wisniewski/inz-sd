package sd.rf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.rf.domain.RequestCategory;

@Repository
@Transactional
public class RequestCategoryDaoImpl extends GenericHibernateDao<RequestCategory> implements RequestCategoryDao {

	public RequestCategoryDaoImpl() {
		super(RequestCategory.class);
	}

	

}
