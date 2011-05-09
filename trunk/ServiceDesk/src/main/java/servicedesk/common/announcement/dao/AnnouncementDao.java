/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.dao;

import java.util.Collection;
import java.util.Date;
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.general.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface AnnouncementDao extends CrudDao<Announcement, Integer> {
    public Collection<Announcement> getUpToDate(Date date);
}
