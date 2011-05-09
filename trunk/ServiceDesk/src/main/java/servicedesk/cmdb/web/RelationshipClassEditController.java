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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/class/{id}/edit")
@PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_EDIT')")
@SessionAttributes("relationshipClass")
public class RelationshipClassEditController extends AbstractRelationshipClassController {

    protected final String VIEW_EDIT = "/cmdb/relationship/class/edit";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer classId) {
        RelationshipClass relationshipClass = service.load(classId);
        map.addAttribute(relationshipClass);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute RelationshipClass relationshipClass,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(relationshipClass, bindingResult);
            messages.addMessage("message.cmdb.relationship.class.edited", relationshipClass.getName());
            status.setComplete();
            return String.format("redirect:/cmdb/relationship/class/%d", relationshipClass.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/relationship/class/%d/edit", relationshipClass.getId());
        }
    }
}
