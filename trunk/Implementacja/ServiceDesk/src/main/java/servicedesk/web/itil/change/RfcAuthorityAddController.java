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
import servicedesk.core.base.employee.service.EmployeeService;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.service.RfcCategoryService;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
@RequestMapping(value = "/change/rfc/authority/*")
@SessionAttributes("authority")
public class RfcAuthorityAddController extends AbstractRfcAuthorityController {
    public static final String VIEW_ADD = "/change/rfc/authority/add";

    @Autowired
    protected EmployeeService employeeService;
    
    @Autowired
    protected RfcCategoryService rfcCategoryService;
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        RfcAuthority rfcAuthority = service.create();
        map.addAttribute("authority", rfcAuthority);
        return String.format("redirect:/change/rfc/authority/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute("authority") RfcAuthority rfcAuthority) {
        map.addAttribute("categories", rfcCategoryService.getAll());
        map.addAttribute("employees", employeeService.getAll());
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute("authority") RfcAuthority rfcAuthority,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfcAuthority, bindingResult);
            messages.addMessage("message.change.rfc.authority.added", rfcAuthority.getName());
            status.setComplete();

            return String.format("redirect:/change/rfc/authority/%d", rfcAuthority.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/authority/new";
        }
    }
}
