package servicedesk.core.itil.pm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.itil.pm.app.KnownErrorSearchCriteria;
import servicedesk.core.itil.pm.domain.KnownError;

@Repository
@Transactional
public class KnownErrorDaoImpl extends GenericHibernateDao<KnownError,Integer> implements KnownErrorDao {

    @Override
    public List<KnownError> search(KnownErrorSearchCriteria searchCriteria) {
            return super.search(searchCriteria);
    }
	
}
