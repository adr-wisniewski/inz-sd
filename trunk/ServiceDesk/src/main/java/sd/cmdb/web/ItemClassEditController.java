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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassEditableValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/{id}/edit")
@PreAuthorize("hasRole('CN_ITC_EDI')")
public class ItemClassEditController extends BaseController {

    protected final String VIEW_EDIT = "/cmdb/item/class/edit";
    protected final String MODEL_ITEMCLASS = "itemClass";

    @Autowired
    private ItemClassEditableValidator itemClassEditableValidator;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("identifier");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") ItemClass itemClass) {
        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(@PathVariable("id") Integer id, @ModelAttribute(MODEL_ITEMCLASS) ItemClass itemClass, BindingResult bindingResult) {

        itemClass.setIdentifier(id);
        itemClassEditableValidator.validate(itemClass, bindingResult);

        if(bindingResult.hasErrors())
            return String.format("prg:/cmdb/item/class/%s/edit", itemClass.getId());

        classService.updateItemClass(itemClass);
        messageStorage.addMessage("cmdb.message.item.class.edited", itemClass.getName());
        return String.format("redirect:/cmdb/item/class/%s", itemClass.getId());
    }
}
