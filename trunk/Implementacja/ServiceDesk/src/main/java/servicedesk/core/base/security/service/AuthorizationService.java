/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.service;

import servicedesk.core.base.security.domain.EmployeeUser;
import servicedesk.core.base.security.domain.User;

/**
 *
 * @author Adrian
 */
public interface AuthorizationService {
    public User getCurrentUser();
    public EmployeeUser getCurrentEmployeeUser();
}
