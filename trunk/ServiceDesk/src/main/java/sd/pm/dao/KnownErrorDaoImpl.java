package sd.pm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.pm.app.KnownErrorSearchCriteria;
import sd.pm.domain.KnownError;

@Repository
@Transactional
public class KnownErrorDaoImpl extends GenericHibernateDao<KnownError> implements KnownErrorDao {

	public KnownErrorDaoImpl() {
		super(KnownError.class);
	}

	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria) {
		return super.search(searchCriteria);
	}
	
}
