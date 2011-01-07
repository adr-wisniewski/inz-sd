/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CN_ITC_ADD')")
@SessionAttributes(ItemClassAddController.MODEL_ITEMCLASS)
public class ItemClassAddController extends BaseController {
    public static final String MODEL_ITEMCLASS = "itemClass";
    public static final String VIEW_ADD = "/cmdb/item/class/add";
    public static final String VIEW_FORM_EXPIRED = "/sd/formExpired";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("identifier");
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
            map.addAttribute(MODEL_ITEMCLASS, new ItemClass());
            return "redirect:/cmdb/item/class/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute(MODEL_ITEMCLASS) ItemClass itemClass) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute(MODEL_ITEMCLASS) ItemClass itemClass,
            BindingResult bindingResult, 
            SessionStatus status) {

        try {
            classService.addItemClass(itemClass);
            messageStorage.addMessage("cmdb.message.item.class.added", itemClass.getName());
            status.setComplete();
            return String.format("redirect:/cmdb/item/class/%d", itemClass.getIdentifier());
        }
        catch(BusinessConstraintException ex) {
            map.addAllAttributes(results.getModel());
            return "prg:/cmdb/item/class/new";
        }
    }
}
