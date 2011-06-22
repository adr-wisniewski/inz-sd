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
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_PRIORITY_CRUD')")
@RequestMapping(value = "/change/rfc/priority/*")
@SessionAttributes(AbstractRfcPriorityController.MODEL_OBJECT)
public class RfcPriorityAddController extends AbstractRfcPriorityController {
    public static final String VIEW_ADD = "/change/rfc/priority/add";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        RfcPriority rfcPriority = new RfcPriority();
        map.addAttribute(rfcPriority);
        return String.format("redirect:/change/rfc/priority/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute RfcPriority rfcPriority) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RfcPriority rfcPriority,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfcPriority, bindingResult);
            messages.addMessage("message.change.rfc.priority.added", rfcPriority.getName());
            status.setComplete();

            return String.format("redirect:/change/rfc/priority/%d", rfcPriority.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/priority/new";
        }
    }
}
