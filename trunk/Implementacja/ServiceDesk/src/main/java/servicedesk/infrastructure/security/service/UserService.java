/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.security.service;

import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
public interface UserService {
    public User getByLogin(String login);
}
