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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.employee.service.EmployeeService;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.core.itil.change.service.RfcCategoryService;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/authority/{id}")
@PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
@SessionAttributes("authority")
public class RfcAuthorityEditController extends AbstractRfcAuthorityController {
    protected final String VIEW_EDIT = "/change/rfc/authority/edit";
    protected final String VIEW_REMOVE_MEMBER = "/change/rfc/authority/member/remove";
    protected final String VIEW_REMOVE_CATEGORY = "/change/rfc/authority/category/remove";
    
    @Autowired
    protected EmployeeService employeeService;
    
    @Autowired
    protected RfcCategoryService rfcCategoryService;
    

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        RfcAuthority rfcAuthority = service.load(id);
        map.addAttribute("authority", rfcAuthority);
        map.addAttribute("categories", rfcCategoryService.getAll());
        map.addAttribute("employees", employeeService.getAll());
        return VIEW_EDIT;
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute("authority") RfcAuthority rfcAuthority,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(rfcAuthority, bindingResult);
            messages.addMessage("message.change.rfc.authority.edited", rfcAuthority.getName());
            status.setComplete();
            return String.format("redirect:/change/rfc/authority/%d", rfcAuthority.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/authority/%d/edit", rfcAuthority.getId());
        }
    }
}
