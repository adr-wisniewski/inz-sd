/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.security.dao;

import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import servicedesk.infrastructure.security.domain.User;
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UserDaoImpl extends AbstractHibernateCrudDao<User, Integer> implements UserDao {
    @Override
    public User getByLogin(String login) {
        List<User> list = getHibernateTemplate().findByNamedQueryAndNamedParam("User.findByLogin", "login", login);
        User user = DataAccessUtils.requiredSingleResult(list);
        getHibernateTemplate().initialize(user.getRoles());
        return user;
    }
}
