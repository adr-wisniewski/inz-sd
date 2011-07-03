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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.change.domain.entity.RfcImpact;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
@RequestMapping(value = "/change/rfc/impact/*")
@SessionAttributes("rfcImpact")
public class RfcImpactAddContoller extends AbstractRfcImpactController {
    public static final String VIEW_ADD = "/change/rfc/impact/add";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        RfcImpact rfcImpact = new RfcImpact();
        map.addAttribute(rfcImpact);
        return String.format("redirect:/change/rfc/impact/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute RfcImpact rfcImpact) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RfcImpact rfcImpact,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfcImpact, bindingResult);
            messages.addMessage("message.change.rfc.impact.added", rfcImpact.getName());
            status.setComplete();

            return String.format("redirect:/change/rfc/impact/%d", rfcImpact.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/impact/new";
        }
    }
}
