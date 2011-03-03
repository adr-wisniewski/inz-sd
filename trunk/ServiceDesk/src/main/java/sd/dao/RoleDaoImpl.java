package sd.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.domain.Role;

@Repository
@Transactional
public class RoleDaoImpl extends GenericHibernateDao<Role,String> implements RoleDao {
	
        @Override
	public Role findByCode(String roleCode) {
		return findByNamedQuery("Role.findByCode", roleCode).get(0);
	}

}
