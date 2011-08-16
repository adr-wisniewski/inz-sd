/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.common.notification.service;

import java.util.List;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.common.notification.domain.Notification;

/**
 *
 * @author Adrian
 */
public interface NotificationService  {
    List<Notification> getForUser(User user);
    
    public void add(Notification object);
    public void update(Notification object);
    public void delete(Notification object);
    
    public Notification load(Integer id);
    public Notification get(Integer id);
}
