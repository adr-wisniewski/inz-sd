/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.security.access.expression.method;

import org.springframework.security.core.Authentication;
import servicedesk.core.base.security.domain.Ownable;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.spring.SpringSecurityUserAdapter;

/**
 *
 * @author Adrian
 */
public class ExtendedMethodSecurityExpressionRoot extends MethodSecurityExpressionRoot {

    public ExtendedMethodSecurityExpressionRoot(Authentication a) {
        super(a);
    }
    
    public boolean isOwner(Ownable object) {
        return object == null ? true : object.getOwner().equals(getCurrentUser());
    }
    
    protected User getCurrentUser() {
        Object principal = authentication.getPrincipal();

        if (!(principal instanceof SpringSecurityUserAdapter))
            throw new IllegalStateException("AuthoredDomainObjectEventListener requires use of SpringSecurityUserAdapter as authentication");

        User user = ((SpringSecurityUserAdapter)principal).getUser();
        return user;
    }
    
}
