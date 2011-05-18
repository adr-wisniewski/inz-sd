/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.dao.hibernate;

import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.event.PersistEvent;
import org.hibernate.event.PersistEventListener;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.interfaces.domain.TimestampAutomaticallyMarked;

/**
 *
 * @author Adrian
 */
@Component
public class CreationTimeMarkedPersistEventListener implements PersistEventListener {
    private static final long serialVersionUID = 1L;
    @Override
    public void onPersist(PersistEvent event) throws HibernateException {

        if(event.getObject() instanceof TimestampAutomaticallyMarked) {
            TimestampAutomaticallyMarked entity = (TimestampAutomaticallyMarked)event.getObject();
            entity.setTimestamp(new Date());
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        onPersist(event);
    }
}
