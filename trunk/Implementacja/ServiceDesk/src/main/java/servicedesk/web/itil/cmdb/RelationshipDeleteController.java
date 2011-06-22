/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/{id}/delete")
@PreAuthorize("hasRole('CMDB_RELATIONSHIP_DELETE')")
@SessionAttributes(RelationshipDeleteController.MODEL_OBJECT)
public class RelationshipDeleteController extends AbstractRelationshipController {
    protected static final String VIEW_DELETE = "/cmdb/relationship/delete";
    public static final String MODEL_OBJECT = "relationship";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer classId) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            Relationship relationship = relationshipService.load(classId);
            map.addAttribute(MODEL_OBJECT, relationship);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) Relationship relationship,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/cmdb/relationship/%d", relationship.getId());
        }

        try {
            relationshipService.delete(relationship);
            messages.addMessage("message.cmdb.relationship.deleted");
            status.setComplete();
            return "redirect:/cmdb/relationship/";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/relationship/%d/delete", relationship.getId());
        }
    }
}
