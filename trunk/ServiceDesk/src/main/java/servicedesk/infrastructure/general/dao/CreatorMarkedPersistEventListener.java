/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.event.PersistEvent;
import org.hibernate.event.PersistEventListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.general.domain.CreatorMarked;
import servicedesk.infrastructure.general.domain.CreatorMarked;
import servicedesk.infrastructure.general.spring.SpringSecurityUserAdapter;
import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
@Component
public class CreatorMarkedPersistEventListener implements PersistEventListener {

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {

        if(event.getObject() instanceof CreatorMarked) {
            CreatorMarked entity = (CreatorMarked)event.getObject();

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (!(principal instanceof SpringSecurityUserAdapter))
                throw new IllegalStateException("AuthoredDomainObjectEventListener requires use of SpringSecurityUserAdapter as authenticationfreeeeeeeeeeeeeeeeeeeeeeeefd");

            User user = ((SpringSecurityUserAdapter)principal).getUser();
            entity.setCreator(user.getEmployee());
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        onPersist(event);
    }

}
