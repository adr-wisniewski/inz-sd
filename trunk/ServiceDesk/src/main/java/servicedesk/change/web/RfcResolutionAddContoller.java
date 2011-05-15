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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.change.domain.RfcResolution;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_RESOLUTION_CRUD')")
@RequestMapping(value = "/change/rfc/resolution/*")
@SessionAttributes("rfcResolution")
public class RfcResolutionAddContoller extends AbstractRfcResolutionController {
    public static final String VIEW_ADD = "/change/rfc/resolution/add";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        RfcResolution rfcResolution = new RfcResolution();
        map.addAttribute(rfcResolution);
        return String.format("redirect:/change/rfc/resolution/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute RfcResolution rfcResolution) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RfcResolution rfcResolution,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfcResolution, bindingResult);
            messages.addMessage("message.change.rfc.resolution.added", rfcResolution.getName());
            status.setComplete();

            return String.format("redirect:/change/rfc/resolution/%d", rfcResolution.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/resolution/new";
        }
    }
}
