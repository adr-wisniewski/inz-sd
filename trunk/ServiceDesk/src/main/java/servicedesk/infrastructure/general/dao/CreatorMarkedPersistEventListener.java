/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.event.PersistEvent;
import org.hibernate.event.PersistEventListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.general.domain.CreatorAutomaticallyMarked;
import servicedesk.infrastructure.general.spring.SpringSecurityUserAdapter;
import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
@Component
public class CreatorMarkedPersistEventListener implements PersistEventListener {
    private static final long serialVersionUID = 1L;

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {

        if(event.getObject() instanceof CreatorAutomaticallyMarked) {
            CreatorAutomaticallyMarked entity = (CreatorAutomaticallyMarked)event.getObject();
            SpringSecurityUserAdapter principal = (SpringSecurityUserAdapter)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = principal.getUser();
            entity.setCreator(user.getEmployee());
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        onPersist(event);
    }

}
