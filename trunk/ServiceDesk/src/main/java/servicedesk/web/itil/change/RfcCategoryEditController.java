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
import servicedesk.core.itil.change.domain.RfcCategory;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/category/{id}/edit")
@PreAuthorize("hasRole('CHANGE_RFC_CATEGORY_CRUD')")
@SessionAttributes("rfcCategory")
public class RfcCategoryEditController extends AbstractRfcCategoryController {
    protected final String VIEW_EDIT = "/change/rfc/category/edit";

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        RfcCategory rfcCategory = service.load(id);
        map.addAttribute(rfcCategory);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute RfcCategory rfcCategory,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(rfcCategory, bindingResult);
            messages.addMessage("message.change.rfc.category.edited", rfcCategory.getName());
            status.setComplete();
            return String.format("redirect:/change/rfc/category/%d", rfcCategory.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/category/%d/edit", rfcCategory.getId());
        }
    }
}
