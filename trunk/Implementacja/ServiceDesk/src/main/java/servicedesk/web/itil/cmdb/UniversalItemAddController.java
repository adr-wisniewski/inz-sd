/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
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
import servicedesk.core.itil.cmdb.domain.EntityClassIsAbstractException;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;
import servicedesk.web.itil.cmdb.helper.UniversalItemClassPickForm;
import servicedesk.web.itil.cmdb.service.UniversalItemClassPickFormService;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/*")
@PreAuthorize("hasRole('CMDB_ITEM_ADD')")
@SessionAttributes(value={AbstractUniversalItemController.MODEL_OBJECT, UniversalItemAddController.MODEL_FORM})
public class UniversalItemAddController extends AbstractUniversalItemController {

    public static final String VIEW_PICK_CLASS = "/cmdb/item/add/pickclass";
    public static final String VIEW_ADD_EDIT = "/cmdb/item/add/attributes";
    public static final String MODEL_FORM = "form";
    
    @Autowired
    protected UniversalItemClassPickFormService pickFormService;

    @InitBinder()
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
        map.addAttribute(MODEL_FORM, new UniversalItemClassPickForm());
        return "redirect:/cmdb/item/new/pickclass";
    }

    @RequestMapping(value="/add/{classId}", method = RequestMethod.GET)
    public String creteNewInstanceWithClass(ModelMap map, @PathVariable("classId") Integer classId) {
            
            UniversalItemClass itemClass = universalItemClassService.load(classId);
            UniversalItem item = itemClass.createItem();
            
            map.addAttribute(item);
            return "redirect:/cmdb/item/new";
    }

    @RequestMapping(value="/new/pickclass", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute(MODEL_FORM) UniversalItemClassPickForm form) {
        return VIEW_PICK_CLASS;
    }

    @RequestMapping(value="/new/pickclass", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute(MODEL_FORM) UniversalItemClassPickForm form,
            BindingResult bindingResult) {
        
        try {
            pickFormService.pick(form, bindingResult);
            return String.format("redirect:/cmdb/item/new");
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/cmdb/item/new/pickclass";
        }
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String editGet(@ModelAttribute UniversalItem item) {
        return VIEW_ADD_EDIT;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
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
            return "prg:/cmdb/item/new";
        }
    }
}
