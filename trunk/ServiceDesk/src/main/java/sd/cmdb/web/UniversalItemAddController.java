/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import freemarker.template.utility.Collections12;
import java.util.Arrays;
import java.util.List;
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
import sd.cmdb.domain.Quantity;
import sd.cmdb.domain.UniversalItem;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/*")
@PreAuthorize("hasRole('CN_ITM_ADD')")
@SessionAttributes("universalItem")
public class UniversalItemAddController extends UniversalItemController {

    public static final String VIEW_ADD_CLASS = "/cmdb/item/add/class";
    public static final String VIEW_ADD_EDIT = "/cmdb/item/add/attributes";


    @InitBinder()
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
            map.addAttribute(new UniversalItem());
            return "redirect:/cmdb/item/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute UniversalItem item) {
        return VIEW_ADD_CLASS;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute UniversalItem item,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.preAdd(item, bindingResult);
            return String.format("redirect:/cmdb/item/new/edit");
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/cmdb/item/new";
        }
    }

    @RequestMapping(value="/new/edit", method = RequestMethod.GET)
    public String editGet(@ModelAttribute UniversalItem item) {
        return VIEW_ADD_EDIT;
    }

    @RequestMapping(value="/new/edit", method = RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute UniversalItem item,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(item, bindingResult);
            messages.addMessage("message.cmdb.item.added");
            status.setComplete();
            return String.format("redirect:/cmdb/item/%d", item.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/cmdb/item/new/edit";
        }
    }
}
