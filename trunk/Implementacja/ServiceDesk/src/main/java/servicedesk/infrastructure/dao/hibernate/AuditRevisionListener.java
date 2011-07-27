/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.dao.hibernate;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import servicedesk.core.base.history.domain.AuditRevisionEntity;
import servicedesk.core.base.security.spring.SpringSecurityUserAdapter;
import servicedesk.core.base.security.domain.User;

/**
 *
 * @author Adrian
 */
public class AuditRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        AuditRevisionEntity revision = (AuditRevisionEntity)revisionEntity;

        SpringSecurityUserAdapter principal = (SpringSecurityUserAdapter)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
                
        revision.setInstigator(user);
    }

}
