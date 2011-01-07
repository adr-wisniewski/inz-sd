package sd.im.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.GenericHibernateDao;
import sd.im.domain.SupportGroup;

@Repository
@Transactional
public class SupportGroupDaoImpl extends GenericHibernateDao<SupportGroup> implements SupportGroupDao {

	public SupportGroupDaoImpl() {
		super(SupportGroup.class);
	}

	public SupportGroup findById(Integer id) {
		return super.findById(id);
	}

}
