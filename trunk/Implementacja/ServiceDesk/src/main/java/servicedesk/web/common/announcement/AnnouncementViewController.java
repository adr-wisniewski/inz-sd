/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.common.announcement;

import java.util.Collection;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.common.announcement.domain.Announcement;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
public class AnnouncementViewController extends AbstractAnnouncementController {
    protected static final String VIEW_GENERAL = "/common/announcement/";
    protected static final String VIEW_VIEW = "/common/announcement/view";
    protected static final String MODEL_ANNOUNCEMENT = "announcement";
    protected static final String MODEL_ANNOUNCEMENTS = "announcements";

    @RequestMapping(value = "/common/announcement")
    public String general(ModelMap model) {
        Collection<Announcement> announcements = service.getAll();
        model.addAttribute(MODEL_ANNOUNCEMENTS, announcements);
        return VIEW_GENERAL;
    }

    @RequestMapping(value = "/common/announcement/{id}")
    public String view(ModelMap model, @PathVariable("id") Integer id) {
        Announcement announcement = service.load(id);
        model.addAttribute(MODEL_ANNOUNCEMENT, announcement);
        return VIEW_VIEW;
    }
}
