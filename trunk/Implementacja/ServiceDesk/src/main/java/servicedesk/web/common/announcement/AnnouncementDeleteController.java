/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.common.announcement;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.common.announcement.domain.Announcement;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/announcement/{id}/delete")
@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
@SessionAttributes(AnnouncementDeleteController.MODEL_OBJECT)
public class AnnouncementDeleteController extends AbstractAnnouncementController {
    public static final String VIEW_DELETE = "/common/announcement/delete";
    public static final String MODEL_OBJECT = "announcement";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer id) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            Announcement announcement = service.load(id);
            map.addAttribute(MODEL_OBJECT, announcement);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) Announcement announcement,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/common/announcement/%d", announcement.getId());
        }

        try {
            service.delete(announcement);
            messages.addMessage("message.common.announcement.deleted", announcement.getTitle());
            status.setComplete();
            return "redirect:/common/announcement";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/common/announcement/%d/delete", announcement.getId());
        }
    }
}
