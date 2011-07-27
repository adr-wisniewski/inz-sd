/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.dao;

import servicedesk.core.base.security.domain.User;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface UserDao extends CrudDao<User, Integer> {
    public User getByLogin(String login);
}
