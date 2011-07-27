/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/{id}/delete")
@PreAuthorize("hasRole('CMDB_ITEMCLASS_DELETE')")
@SessionAttributes(ItemClassDeleteController.MODEL_OBJECT)
public class ItemClassDeleteController extends AbstractItemClassController {
    protected static final String VIEW_DELETE = "/cmdb/item/class/delete";
    public static final String MODEL_OBJECT = "universalItemClass";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer classId) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            UniversalItemClass itemClass = service.load(classId);
            map.addAttribute(MODEL_OBJECT, itemClass);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) UniversalItemClass itemClass,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/cmdb/item/class/%d", itemClass.getId());
        }

        try {
            service.delete(itemClass);
            messages.addMessage("message.cmdb.item.class.deleted", itemClass.getName());
            status.setComplete();
            return "redirect:/cmdb/item/class/";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/item/class/%d/delete", itemClass.getId());
        }
    }
}
