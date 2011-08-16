/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

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
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/authority/{id}/delete")
@PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
@SessionAttributes("authority")
public class RfcAuthorityDeleteController extends AbstractRfcAuthorityController {
    protected static final String VIEW_DELETE = "/change/rfc/authority/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer id) {
        RfcAuthority rfcAuthority = service.load(id);
        map.addAttribute("authority", rfcAuthority);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute("authority") RfcAuthority rfcAuthority,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/change/rfc/authority/%d", rfcAuthority.getId());
        }

        try {
            service.delete(rfcAuthority);
            messages.addMessage("message.change.rfc.authority.deleted", rfcAuthority.getName());
            status.setComplete();
            return "redirect:/change/rfc/authority";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/authority/%d/delete", rfcAuthority.getId());
        }
    }
}
