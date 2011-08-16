/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.common.notification.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.common.notification.dao.NotificationDao;
import servicedesk.core.common.notification.domain.Notification;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    protected NotificationDao dao;

    @Override
    public void add(Notification object) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("isOwner(#object)")
    public void update(Notification object) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("isOwner(#object)")
    public void delete(Notification object) {
        dao.remove(object);
    }

    @Override
    @PostAuthorize("isOwner(returnObject)")
    public Notification load(Integer id) {
        return dao.load(id);
    }

    @Override
    @PostAuthorize("isOwner(returnObject)")
    public Notification get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Notification> getForUser(User user) {
        return dao.getForUser(user);
    }
    
}
