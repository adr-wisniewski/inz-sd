/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

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
import sd.cmdb.domain.RelationshipClass;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/class/*")
@PreAuthorize("hasRole('CN_RLC_ADD')")
@SessionAttributes("relationshipClass")
public class RelationshipClassAddController extends RelationshipClassController {
    public static final String VIEW_ADD = "/cmdb/relationship/class/add";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
        dataBinder.setDisallowedFields("children");
        dataBinder.setDisallowedFields("attributes");

        dataBinder.setDisallowedFields("sourceUniversalItemClass");
        dataBinder.setDisallowedFields("targetUniversalItemClass");
        dataBinder.setDisallowedFields("sourceType");
        dataBinder.setDisallowedFields("targetType");
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map) {
            map.addAttribute(new RelationshipClass());
            return "redirect:/cmdb/relationship/class/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute RelationshipClass itemClass) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute RelationshipClass relationshipClass,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.add(relationshipClass, bindingResult);
            messages.addMessage("message.cmdb.relationship.class.added", relationshipClass.getName());
            status.setComplete();

            return String.format("redirect:/cmdb/relationship/class/%d", relationshipClass.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());

            return "prg:/cmdb/relationship/class/new";
        }
    }
}
