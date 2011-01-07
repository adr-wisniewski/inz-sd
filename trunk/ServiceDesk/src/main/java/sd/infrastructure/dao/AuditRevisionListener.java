/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.dao;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sd.infrastructure.domain.AuditRevisionEntity;

/**
 *
 * @author Adrian
 */
public class AuditRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        AuditRevisionEntity revision = (AuditRevisionEntity)revisionEntity;

        // TODO: inject username
        // TODO: change username to userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        revision.setUsername(authentication.getName());
    }

}
