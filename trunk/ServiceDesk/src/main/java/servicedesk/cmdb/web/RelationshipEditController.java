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
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/{id}/edit")
@PreAuthorize("hasRole('CMDB_RELATIONSHIP_EDIT')")
@SessionAttributes("relationship")
public class RelationshipEditController extends BaseRelationshipController {
    protected final String VIEW_EDIT = "/cmdb/relationship/edit";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
        dataBinder.setDisallowedFields("relationshipClass");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer classId) {
        Relationship relationship = relationshipService.load(classId);
        relationship.populateAttributeValues();
        map.addAttribute(relationship);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute Relationship relationship,
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
