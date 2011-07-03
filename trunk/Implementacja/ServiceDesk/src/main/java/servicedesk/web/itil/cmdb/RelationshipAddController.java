/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

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
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/*")
@PreAuthorize("hasRole('CMDB_RELATIONSHIP_ADD')")
@SessionAttributes({"relationship", "origin"})
public class RelationshipAddController extends AbstractRelationshipController {

    public static final String VIEW_ADD = "/cmdb/relationship/add";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("version");
        dataBinder.setDisallowedFields("relationshipClass");
    }

    @RequestMapping(value="/add/{classid}/source/{itemid}", method = RequestMethod.GET)
    public String creteNewInstanceFromSource(ModelMap map,
            @PathVariable("classid") Integer classId,
            @PathVariable("itemid") Integer itemId) {

        RelationshipClass relationshipClass = relationshipClassService.load(classId);
        Relationship relationship = relationshipClass.createRelationship();
        
        Item item = itemService.load(itemId);
        relationship.setSourceItem(item);
        
        map.addAttribute(relationship);
        map.addAttribute("origin", item);
        return "redirect:/cmdb/relationship/new";
    }

    @RequestMapping(value="/add/{classid}/target/{itemid}", method = RequestMethod.GET)
    public String creteNewInstanceFromTarget(ModelMap map,
            @PathVariable("classid") Integer classId,
            @PathVariable("itemid") Integer itemId) {

        RelationshipClass relationshipClass = relationshipClassService.load(classId);
        Relationship relationship = relationshipClass.createRelationship();
        
        Item item = itemService.load(itemId);
        relationship.setTargetItem(item); 

        map.addAttribute(relationship);
        map.addAttribute("origin", item);
        return "redirect:/cmdb/relationship/new";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(@ModelAttribute Relationship relationship) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute("origin") Item origin,
            @ModelAttribute Relationship relationship,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            relationshipService.add(relationship, bindingResult);
            messages.addMessage("message.cmdb.relationship.added");
            status.setComplete();

            return String.format("redirect:/cmdb/item/%d", origin.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());

            return "prg:/cmdb/relationship/new";
        }
    }
}
