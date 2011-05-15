/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

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
import servicedesk.change.domain.RfcPriority;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/priority/{id}/delete")
@PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
@SessionAttributes("rfcPriority")
public class RfcPriorityDeleteController extends AbstractRfcPriorityController {
    protected static final String VIEW_DELETE = "/change/rfc/priority/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer id) {
        RfcPriority rfcPriority = service.load(id);
        map.addAttribute(rfcPriority);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute RfcPriority rfcPriority,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/change/rfc/priority/%d", rfcPriority.getId());
        }

        try {
            service.delete(rfcPriority);
            messages.addMessage("message.change.rfc.priority.deleted", rfcPriority.getName());
            status.setComplete();
            return "redirect:/change/rfc/priority";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/priority/%d/delete", rfcPriority.getId());
        }
    }
}
