/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.announcement.service;

import java.util.Collection;
import java.util.Date;
import servicedesk.core.common.announcement.domain.Announcement;
import servicedesk.infrastructure.interfaces.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface AnnouncementService extends CrudService<Announcement, Integer> {
    public Collection<Announcement> getUpToDate(Date date);
}
