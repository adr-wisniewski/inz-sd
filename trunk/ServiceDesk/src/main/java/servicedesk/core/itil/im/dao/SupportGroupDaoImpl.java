package servicedesk.core.itil.im.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.itil.im.domain.SupportGroup;

@Repository
@Transactional
public class SupportGroupDaoImpl extends GenericHibernateDao<SupportGroup,Integer> implements SupportGroupDao {

}
