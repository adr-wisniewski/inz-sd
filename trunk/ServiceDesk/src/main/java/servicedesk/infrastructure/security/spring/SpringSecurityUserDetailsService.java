/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import servicedesk.infrastructure.security.spring.SpringSecurityUserAdapter;
import servicedesk.infrastructure.security.domain.User;
import servicedesk.infrastructure.security.service.UserService;

/**
 *
 * @author Adrian
 */
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {

    @Autowired
    protected UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = userService.getByLogin(username);

        if(user == null)
            throw new UsernameNotFoundException("Could not find user: " + username, username);

        return new SpringSecurityUserAdapter(user);
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof SpringSecurityUserAdapter))
            throw new IllegalStateException("AuthoredDomainObjectEventListener requires use of SpringSecurityUserAdapter as authentication");

        User user = ((SpringSecurityUserAdapter)principal).getUser();
        return user;
    }
}
