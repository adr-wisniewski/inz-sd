/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.common.notification.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.common.notification.domain.Notification;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;


/**
 *
 * @author Adrian
 */
@Repository
public class NotificationDaoImpl extends AbstractHibernateDao<Notification, Notification, Integer> implements NotificationDao {

    @Override
    public List<Notification> getForUser(User user) {
        return getHibernateTemplate().findByNamedQueryAndNamedParam("Notification.forUser", "user", user);
    }
}
