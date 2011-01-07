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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassDeleteableValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/{id}/delete")
@PreAuthorize("hasRole('CN_ITC_DEL')")
public class ItemClassDeleteController extends BaseController {
    protected static final String VIEW_DELETE = "/cmdb/item/class/delete";
    protected static final String MODEL_ITEMCLASS = "itemClass";

    @Autowired
    private ItemClassDeleteableValidator itemClassDeleteableValidator;

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") ItemClass itemClass) {
        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @PathVariable("id") ItemClass itemClass,
            @RequestParam("submit") String submit)
    {
        if(!submit.equals("ok"))
            return String.format( "redirect:/cmdb/item/class/%s", itemClass.getId());

        DataBinder binder = new DataBinder(itemClass, "target");
        binder.setValidator(itemClassDeleteableValidator);
        binder.validate();
        BindingResult results = binder.getBindingResult();

        if(results.hasErrors())
        {
            map.addAttribute(MODEL_ITEMCLASS, itemClass);
            map.addAllAttributes(results.getModel());
            return String.format("prg:/cmdb/item/class/%s/delete", itemClass.getId());
        }

        administrationService.deleteItemClass(itemClass);
        messageStorage.addMessage("cmdb.message.item.class.deleted", itemClass.getName());
        return "redirect:/cmdb/item/class/";
    }
}
