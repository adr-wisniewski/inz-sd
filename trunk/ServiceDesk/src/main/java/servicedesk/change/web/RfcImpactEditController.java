/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/impact/{id}/edit")
@PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
@SessionAttributes(AbstractRfcImpactController.MODEL_OBJECT)
public class RfcImpactEditController extends AbstractRfcImpactController {
    protected final String VIEW_EDIT = "/change/rfc/impact/edit";

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            RfcImpact rfcImpact = service.load(id);
            map.addAttribute(MODEL_OBJECT, rfcImpact);
        }
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute(MODEL_OBJECT) RfcImpact rfcImpact,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(rfcImpact, bindingResult);
            messages.addMessage("message.change.rfc.impact.edited", rfcImpact.getName());
            status.setComplete();
            return String.format("redirect:/change/rfc/impact/%d", rfcImpact.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/impact/%d/edit", rfcImpact.getId());
        }
    }
}
