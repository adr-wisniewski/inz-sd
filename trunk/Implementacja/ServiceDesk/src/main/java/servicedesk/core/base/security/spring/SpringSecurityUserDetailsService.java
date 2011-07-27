/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.service.UserService;

/**
 *
 * @author Adrian
 */
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    protected UserService userService;
    
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = userService.getByLogin(username);

        if(user == null)
            throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"), username);

        SpringSecurityUserAdapter userAdapter = new SpringSecurityUserAdapter(user);
        
        if(userAdapter.getAuthorities().isEmpty()) {
            logger.debug("User '" + username + "' has no authorities and will be treated as 'not found'");

            throw new UsernameNotFoundException(
                    messages.getMessage("JdbcDaoImpl.noAuthority",
                            new Object[] {username}, "User {0} has no GrantedAuthority"), username);
        }
         
        return userAdapter;
    }
}
