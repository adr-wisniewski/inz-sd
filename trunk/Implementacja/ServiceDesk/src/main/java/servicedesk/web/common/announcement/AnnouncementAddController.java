/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.common.announcement;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.common.announcement.domain.Announcement;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;
import servicedesk.core.base.security.service.AuthorizationService;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/announcement/*")
@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
@SessionAttributes("announcement")
public class AnnouncementAddController extends AbstractAnnouncementController {
    public static final String VIEW_ADD = "/common/announcement/add";
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        Announcement announcement = service.create();
        map.addAttribute(announcement);
        return String.format("redirect:/common/announcement/new");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute Announcement announcement) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute Announcement announcement,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(announcement, bindingResult);
            messages.addMessage("message.common.announcement.added", announcement.getTitle());
            status.setComplete();

                return String.format("redirect:/common/announcement/%d", announcement.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/common/announcement/new";
        }
    }
}
