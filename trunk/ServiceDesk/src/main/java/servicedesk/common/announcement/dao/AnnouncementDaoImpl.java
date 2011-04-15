/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.dao;

import java.util.Collection;
import java.util.Date;
import org.springframework.stereotype.Repository;
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class AnnouncementDaoImpl extends AbstractHibernateCrudDao<Announcement, Integer> implements AnnouncementDao {
    @Override
    public Collection<Announcement> getUpToDate(Date date) {
        return getHibernateTemplate().findByNamedQueryAndNamedParam("Announcement.upToDate", "date", date);
    }
}
