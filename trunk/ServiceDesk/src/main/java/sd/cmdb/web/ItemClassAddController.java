/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

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
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CN_ITC_ADD')")
@SessionAttributes(types=ItemClass.class)
public class ItemClassAddController extends ItemClassBaseController {
    public static final String VIEW_ADD = "/cmdb/item/class/add";
    public static final String VIEW_FORM_EXPIRED = "/sd/formExpired";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
            map.addAttribute(new ItemClass());
            return "redirect:/cmdb/item/class/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute ItemClass itemClass) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute ItemClass itemClass,
            BindingResult bindingResult, 
            SessionStatus status) {

        try {
            itemClassCrudService.add(itemClass, bindingResult);
            messageStorage.addMessage("cmdb.message.item.class.added", itemClass.getName());
            status.setComplete();

            return String.format("redirect:/cmdb/item/class/%d", itemClass.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            
            return "prg:/cmdb/item/class/new";
        }
    }
}
