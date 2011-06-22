/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change2.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import servicedesk.core.itil.change2.domain.ChangeUser;
import servicedesk.core.itil.change2.domain.Rfc;
import servicedesk.infrastructure.interfaces.domain.DomainActor;
import servicedesk.infrastructure.security.spring.SpringSecurityUserDetailsService;

/**
 *
 * @author Adrian
 */
public class RfcService extends AbstractRfcService {
    
    //@Autowired
    //protected SpringSecurityUserDetailsService userService;
    
    public Rfc createNew() {
        return asChangeUser().createRfc();
    }
    
    //@PreAuthorize("ROLE_CHANGE_USER")
   // public ChangeUser asChangeUser() {
    //    return new ChangeUser(userService.getCurrentUser());
    //}
}
