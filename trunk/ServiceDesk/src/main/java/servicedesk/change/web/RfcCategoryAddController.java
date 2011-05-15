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
import servicedesk.change.domain.RfcCategory;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_CATEGORY_CRUD')")
@RequestMapping(value = "/change/rfc/category/*")
@SessionAttributes("rfcCategory")
public class RfcCategoryAddController extends AbstractRfcCategoryController {
     public static final String VIEW_ADD = "/change/rfc/category/add";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        RfcCategory rfcCategory = new RfcCategory();
        map.addAttribute(rfcCategory);
        return String.format("redirect:/change/rfc/category/new");
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute RfcCategory rfcCategory) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RfcCategory rfcCategory,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(rfcCategory, bindingResult);
            messages.addMessage("message.change.rfc.category.added", rfcCategory.getName());
            status.setComplete();

            return String.format("redirect:/change/rfc/category/%d", rfcCategory.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/category/new";
        }
    }
}
