/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.change.domain.entity.RfcImpl;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.itil.change.domain.entity.Rfc;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_ADD')")
@RequestMapping(value = "/change/rfc/*")
@SessionAttributes("rfc")
public class RfcAddController extends AbstractRfcController {
    public static final String VIEW_ADD = "/change/rfc/add";

    @Autowired
    protected AuthorizationService authorizationService;
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        Rfc rfc = service.create();
        map.addAttribute(rfc);
        return String.format("redirect:/change/rfc/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute RfcImpl rfc) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RfcImpl rfc,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfc, bindingResult);
            messages.addMessage("message.change.rfc.added", rfc.getId(), rfc.getTitle());
            status.setComplete();

            return String.format("redirect:/change/rfc/%d", rfc.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/new";
        }
    }
}
