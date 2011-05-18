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
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/{id}/delete")
@PreAuthorize("hasRole('CMDB_ITEM_DELETE')")
@SessionAttributes(AbstractUniversalItemController.MODEL_OBJECT)
public class UniversalItemDeleteController extends AbstractUniversalItemController {
    protected static final String VIEW_DELETE = "/cmdb/item/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer classId) {
        // TODO: deleting of non universal items??
        if(!map.containsAttribute(MODEL_OBJECT)) {
            UniversalItem item = service.load(classId);
            map.addAttribute(MODEL_OBJECT, item);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) UniversalItem item,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/cmdb/item/%d", item.getId());
        }

        try {
            service.delete(item);
            messages.addMessage("message.cmdb.item.deleted");
            status.setComplete();
            return "redirect:/cmdb/item/";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/item/%s/delete", item.getId());
        }
    }
}
