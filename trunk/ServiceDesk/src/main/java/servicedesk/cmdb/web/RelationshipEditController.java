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
import servicedesk.cmdb.domain.Relationship;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/{id}/edit")
@PreAuthorize("hasRole('CMDB_RELATIONSHIP_EDIT')")
@SessionAttributes(RelationshipEditController.MODEL_OBJECT)
public class RelationshipEditController extends AbstractRelationshipController {
    protected final String VIEW_EDIT = "/cmdb/relationship/edit";
    public static final String MODEL_OBJECT = "relationship";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
        dataBinder.setDisallowedFields("relationshipClass");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer classId) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            Relationship relationship = relationshipService.load(classId);
            relationship.populateAttributeValues();
            map.addAttribute(MODEL_OBJECT, relationship);
        }
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute(MODEL_OBJECT) Relationship relationship,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            relationshipService.update(relationship, bindingResult);
            messages.addMessage("message.cmdb.relationship.edited");
            status.setComplete();
            return String.format("redirect:/cmdb/relationship/%d", relationship.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/relationship/%d/edit", relationship.getId());
        }
    }
}
