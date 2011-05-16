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
import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/impact/{id}/delete")
@PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
@SessionAttributes(AbstractRfcImpactController.MODEL_OBJECT)
public class RfcImpactDeleteController extends AbstractRfcImpactController {
    protected static final String VIEW_DELETE = "/change/rfc/impact/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer id) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            RfcImpact rfcImpact = service.load(id);
            map.addAttribute(MODEL_OBJECT, rfcImpact);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) RfcImpact rfcImpact,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/change/rfc/impact/%d", rfcImpact.getId());
        }

        try {
            service.delete(rfcImpact);
            messages.addMessage("message.change.rfc.impact.deleted", rfcImpact.getName());
            status.setComplete();
            return "redirect:/change/rfc/impact";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/impact/%d/delete", rfcImpact.getId());
        }
    }
}
