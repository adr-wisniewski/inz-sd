/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.service;

import servicedesk.core.base.security.domain.User;
import servicedesk.infrastructure.interfaces.service.LoadService;

/**
 *
 * @author Adrian
 */
public interface UserService extends LoadService<User, Integer> {
    public User getByLogin(String login);
}
