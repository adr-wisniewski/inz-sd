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
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/class/{id}/delete")
@PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_DELETE')")
@SessionAttributes(RelationshipClassDeleteController.MODEL_OBJECT)
public class RelationshipClassDeleteController extends AbstractRelationshipClassController {
    protected static final String VIEW_DELETE = "/cmdb/relationship/class/delete";
    public static final String MODEL_OBJECT = "relationshipClass";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map, @PathVariable("id") Integer classId) {
        if(!map.containsAttribute(MODEL_OBJECT)) {
            RelationshipClass relationshipClass = service.load(classId);
            map.addAttribute(MODEL_OBJECT, relationshipClass);
        }
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @ModelAttribute(MODEL_OBJECT) RelationshipClass relationshipClass,
            @RequestParam("submit") String submit,
            SessionStatus status) {

        if(!submit.equals("ok")) {
            status.setComplete();
            return String.format( "redirect:/cmdb/relationship/class/%d", relationshipClass.getId());
        }

        try {
            service.delete(relationshipClass);
            messages.addMessage("message.cmdb.relationship.class.deleted", relationshipClass.getName());
            status.setComplete();
            return "redirect:/cmdb/relationship/class/";
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/relationship/class/%d/delete", relationshipClass.getId());
        }
    }
}
