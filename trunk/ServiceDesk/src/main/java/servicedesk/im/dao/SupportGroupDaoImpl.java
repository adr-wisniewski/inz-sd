package servicedesk.im.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.GenericHibernateDao;
import servicedesk.im.domain.SupportGroup;

@Repository
@Transactional
public class SupportGroupDaoImpl extends GenericHibernateDao<SupportGroup,Integer> implements SupportGroupDao {

}
