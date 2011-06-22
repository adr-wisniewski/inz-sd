/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change2.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import servicedesk.core.itil.change2.domain.ChangeManager;
import servicedesk.core.itil.change2.domain.ChangeUser;
import servicedesk.infrastructure.security.service.AuthorizationService;

/**
 *
 * @author Adrian
 */
public class AbstractRfcService {
    @Autowired
    protected AuthorizationService authorizationService;
    
    @PreAuthorize("ROLE_CHANGE_USER")
    public ChangeUser asChangeUser() {
        return new ChangeUser(authorizationService.getCurrentUser());
    }
    
    @PreAuthorize("ROLE_CHANGE_MANAGER")
    public ChangeManager asChangeManager() {
        return new ChangeManager(authorizationService.getCurrentUser());
    }
}
