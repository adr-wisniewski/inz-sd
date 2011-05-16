/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/announcement/{id}/edit")
@PreAuthorize("hasRole('COMMON_ANNOUNCEMENT_CRUD')")
@SessionAttributes(AnnouncementEditController.MODEL_OBJECT)
public class AnnouncementEditController extends AbstractAnnouncementController {
    protected final String VIEW_EDIT = "/common/announcement/edit";
    public static final String MODEL_OBJECT = "announcement";

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            Announcement announcement = service.load(id);
            map.addAttribute(MODEL_OBJECT, announcement);
        }
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute(MODEL_OBJECT) Announcement announcement,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(announcement, bindingResult);
            messages.addMessage("message.common.announcement.edited", announcement.getTitle());
            status.setComplete();
            return String.format("redirect:/common/announcement/%d", announcement.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/common/announcement/%d/edit", announcement.getId());
        }
    }
}
