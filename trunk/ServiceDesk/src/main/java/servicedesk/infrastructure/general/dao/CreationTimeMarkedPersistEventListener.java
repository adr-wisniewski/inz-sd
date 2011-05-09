/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.event.PersistEvent;
import org.hibernate.event.PersistEventListener;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.general.domain.CreationTimeMarked;

/**
 *
 * @author Adrian
 */
@Component
public class CreationTimeMarkedPersistEventListener implements PersistEventListener {
    @Override
    public void onPersist(PersistEvent event) throws HibernateException {

        if(event.getObject() instanceof CreationTimeMarked) {
            CreationTimeMarked entity = (CreationTimeMarked)event.getObject();
            entity.setCreationTimestamp(new Date());
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        onPersist(event);
    }
}
