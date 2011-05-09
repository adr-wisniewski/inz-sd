/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.security.dao;

import servicedesk.infrastructure.security.domain.User;
import servicedesk.infrastructure.general.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface UserDao extends CrudDao<User, Integer> {
    public User getByLogin(String login);
}
