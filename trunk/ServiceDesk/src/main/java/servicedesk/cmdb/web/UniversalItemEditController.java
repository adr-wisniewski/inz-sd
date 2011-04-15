/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.util.Collections;
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
import servicedesk.cmdb.domain.Attribute;
import servicedesk.cmdb.domain.AttributeValue;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/{id}/edit")
@PreAuthorize("hasRole('CMDB_ITEM_EDIT')")
@SessionAttributes("universalItem")
public class UniversalItemEditController extends BaseUniversalItemController {
    protected final String VIEW_EDIT = "/cmdb/item/edit";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
        dataBinder.setDisallowedFields("itemClass");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        UniversalItem item = service.load(id);
        item.populateAttributeValues();
        map.addAttribute(item);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute UniversalItem item,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(item, bindingResult);
            messages.addMessage("message.cmdb.item.edited");
            status.setComplete();
            return String.format("redirect:/cmdb/item/%d", item.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/item/%d/edit", item.getId());
        }
    }
}
