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
public interface AuthorizationService {
    public User getCurrentUser();
    public void requireRole(String role);
}
