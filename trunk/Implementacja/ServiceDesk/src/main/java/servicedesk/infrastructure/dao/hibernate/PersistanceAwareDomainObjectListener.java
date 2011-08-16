/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.dao.hibernate;

import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.event.PersistEvent;
import org.hibernate.event.PersistEventListener;
import servicedesk.infrastructure.interfaces.domain.PersistanceAwareDomainObject;

/**
 *
 * @author Adrian
 */
public class PersistanceAwareDomainObjectListener implements PersistEventListener {
    private static final long serialVersionUID = 1L;
    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        if(event.getObject() instanceof PersistanceAwareDomainObject<?>) {
            PersistanceAwareDomainObject<?> entity = (PersistanceAwareDomainObject<?>)event.getObject();
            entity.onPersist();
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        onPersist(event);
    }
}
