/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.dao;

import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Adrian
 */
public class AuthoredDomainObjectEventListener implements PreInsertEventListener  {

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        String username;

        if (principal instanceof UserDetails) {
          username = ((UserDetails)principal).getUsername();
        } else {
          username = principal.toString();
        }
    }

}
