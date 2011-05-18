/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.announcement.dao;

import java.util.Collection;
import java.util.Date;
import servicedesk.core.common.announcement.domain.Announcement;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface AnnouncementDao extends CrudDao<Announcement, Integer> {
    public Collection<Announcement> getUpToDate(Date date);
}
