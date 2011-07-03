/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.announcement.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.core.base.employee.domain.EmployeeUser;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.common.announcement.dao.AnnouncementDao;
import servicedesk.core.common.announcement.domain.Announcement;
import servicedesk.core.common.announcement.validator.AnnouncementSimpleValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
//@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_VIEW')")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    protected AnnouncementDao dao;
    
    @Autowired
    protected AuthorizationService authorizationService;

    @Override
    public Collection<Announcement> getUpToDate(Date date) {
        return dao.getUpToDate(date);
    }

    @Override
    public Announcement load(Integer id) {
        return dao.load(id);
    }

    @Override
    public Announcement get(Integer id) {
        return dao.get(id);
    }

    @Override
    @PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
    @Validated(validator=AnnouncementSimpleValidator.class)
    public void add(Announcement object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
    @Validated(validator=AnnouncementSimpleValidator.class)
    public void update(Announcement object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
    //@Validated(validator=AnnouncementDeleteValidator.class)
    public void delete(Announcement object) {
        dao.remove(object);
    }

    @Override
    public List<Announcement> getAll() {
        return dao.getAll();
    }

    @Override
    public Announcement create() {
        EmployeeUser user = authorizationService.getCurrentEmployeeUser();
        Announcement announcement = new Announcement(user.getEmployee());
        announcement.setPublicationTime(new Date());
        return announcement;
    }

}
