/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.service;

import java.util.Collection;
import java.util.Date;
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface AnnouncementService extends CrudService<Announcement, Integer> {
    public Collection<Announcement> getUpToDate(Date date);
    public Collection<Announcement> getAll();
}
