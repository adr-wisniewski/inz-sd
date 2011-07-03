/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.employee.domain.EmployeeUser;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.spring.SpringSecurityUserAdapter;

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
    
    @Override
    public EmployeeUser getCurrentEmployeeUser() {
        EmployeeUser user = (EmployeeUser)getCurrentUser();
        return user;
    }
}
