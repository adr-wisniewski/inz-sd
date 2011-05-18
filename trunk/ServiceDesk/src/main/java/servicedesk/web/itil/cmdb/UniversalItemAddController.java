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
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/*")
@PreAuthorize("hasRole('CMDB_ITEM_ADD')")
@SessionAttributes(AbstractUniversalItemController.MODEL_OBJECT)
public class UniversalItemAddController extends AbstractUniversalItemController {

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

    @RequestMapping(value="/add/{classId}", method = RequestMethod.GET)
    public String creteNewInstanceWithClass(ModelMap map, @PathVariable("classId") Integer classId) {
            UniversalItem item = new UniversalItem();
            UniversalItemClass itemClass = universalItemClassService.load(classId);
            item.setItemClass(itemClass);
            itemClass.getId();
            itemClass.getName();
            
            map.addAttribute(item);
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
