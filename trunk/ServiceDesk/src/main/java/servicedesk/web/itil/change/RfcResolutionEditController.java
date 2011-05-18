/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

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
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/resolution/{id}/edit")
@PreAuthorize("hasRole('CHANGE_RFC_RESOLUTION_CRUD')")
@SessionAttributes(RfcResolutionEditController.MODEL_OBJECT)
public class RfcResolutionEditController extends AbstractRfcResolutionController {
    public static final String VIEW_EDIT = "/change/rfc/resolution/edit";

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            RfcResolution rfcResolution = service.load(id);
            map.addAttribute(MODEL_OBJECT, rfcResolution);
        }
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute(MODEL_OBJECT) RfcResolution rfcResolution,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(rfcResolution, bindingResult);
            messages.addMessage("message.change.rfc.resolution.edited", rfcResolution.getName());
            status.setComplete();
            return String.format("redirect:/change/rfc/resolution/%d", rfcResolution.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/resolution/%d/edit", rfcResolution.getId());
        }
    }
}
