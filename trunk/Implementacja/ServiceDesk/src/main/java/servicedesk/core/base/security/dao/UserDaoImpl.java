/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.dao;

import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import servicedesk.core.base.security.domain.User;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UserDaoImpl extends AbstractHibernateDao<User, User, Integer> implements UserDao {
    @Override
    public User getByLogin(String login) {
        @SuppressWarnings("unchecked")
        List<User> list = getHibernateTemplate().findByNamedQueryAndNamedParam("User.findByLogin", "login", login);
        User user = DataAccessUtils.singleResult(list);
        
        if(user != null)
            getHibernateTemplate().initialize(user.getRoles());
        
        return user;
    }
}
