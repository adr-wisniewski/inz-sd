/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

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
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CMDB_ITEMCLASS_ADD')")
@SessionAttributes("universalItemClass")
public class ItemClassAddController extends AbstractItemClassController {
    public static final String VIEW_ADD = "/cmdb/item/class/add";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
            map.addAttribute(new UniversalItemClass());
            return "redirect:/cmdb/item/class/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute UniversalItemClass itemClass) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute UniversalItemClass itemClass,
            BindingResult bindingResult, 
            SessionStatus status) {

        try {
            service.add(itemClass, bindingResult);
            messages.addMessage("message.cmdb.item.class.added", itemClass.getName());
            status.setComplete();

            return String.format("redirect:/cmdb/item/class/%d", itemClass.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            
            return "prg:/cmdb/item/class/new";
        }
    }
}
