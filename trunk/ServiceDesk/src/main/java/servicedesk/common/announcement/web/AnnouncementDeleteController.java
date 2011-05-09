/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.web;

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
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/announcement/{id}/delete")
@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
@SessionAttributes("announcement")
public class AnnouncementDeleteController extends AbstractAnnouncementController {
    protected static final String VIEW_DELETE = "/common/announcement/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer id) {
        Announcement announcement = service.load(id);
        map.addAttribute(announcement);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute Announcement announcement,
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
