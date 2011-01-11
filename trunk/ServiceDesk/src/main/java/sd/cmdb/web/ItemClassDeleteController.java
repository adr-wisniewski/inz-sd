/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassDeleteableValidator;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/{id}/delete")
@PreAuthorize("hasRole('CN_ITC_DEL')")
@SessionAttributes(types=ItemClass.class)
public class ItemClassDeleteController extends ItemClassBaseController {
    protected static final String VIEW_DELETE = "/cmdb/item/class/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer classId) {
        ItemClass itemClass = itemClassCrudService.load(classId);
        map.addAttribute(itemClass);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute ItemClass itemClass,
            @RequestParam("submit") String submit,
            SessionStatus status)
    {
        String viewName;

        try {
            if(submit.equals("ok")) {
                itemClassCrudService.delete(itemClass);
                messageStorage.addMessage("cmdb.message.item.class.deleted", itemClass.getName());
                viewName = "redirect:/cmdb/item/class/";
            }
            else {
                viewName =  String.format( "redirect:/cmdb/item/class/%d", itemClass.getId());
            }
            
            status.setComplete();
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            viewName = String.format("prg:/cmdb/item/class/%s/delete", itemClass.getId());
        }

        return viewName;
    }
}
