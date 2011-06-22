/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import servicedesk.infrastructure.security.domain.User;
import servicedesk.infrastructure.security.spring.SpringSecurityUserAdapter;

/**
 *
 * @author Adrian
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
      public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof SpringSecurityUserAdapter))
            throw new IllegalStateException("AuthoredDomainObjectEventListener requires use of SpringSecurityUserAdapter as authentication");

        User user = ((SpringSecurityUserAdapter)principal).getUser();
        return user;
    }
    
    @PreAuthorize("hasRole(#role)")
    @Override
    public void requireRole(String role) {
        // done in @preauthorize
    }
}
