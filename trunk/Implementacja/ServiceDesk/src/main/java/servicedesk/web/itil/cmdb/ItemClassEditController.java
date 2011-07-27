/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/{id}/edit")
@PreAuthorize("hasRole('CMDB_ITEMCLASS_EDIT')")
@SessionAttributes(ItemClassEditController.MODEL_OBJECT)
public class ItemClassEditController extends AbstractItemClassController {

    protected final String VIEW_EDIT = "/cmdb/item/class/edit";
    public static final String MODEL_OBJECT = "universalItemClass";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer classId) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            UniversalItemClass itemClass = service.load(classId);
            map.addAttribute(MODEL_OBJECT, itemClass);
        }
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute(MODEL_OBJECT) UniversalItemClass itemClass,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(itemClass, bindingResult);
            messages.addMessage("message.cmdb.item.class.edited", itemClass.getName());
            status.setComplete();
            return String.format("redirect:/cmdb/item/class/%s", itemClass.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/item/class/%s/edit", itemClass.getId());
        }
    }
}
