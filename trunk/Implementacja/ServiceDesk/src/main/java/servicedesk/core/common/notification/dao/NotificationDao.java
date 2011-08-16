/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.common.notification.dao;

import java.util.List;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.common.notification.domain.Notification;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface NotificationDao extends CrudDao<Notification, Integer> {

    public List<Notification> getForUser(User user);
    
}
