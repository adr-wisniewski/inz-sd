/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.cmdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicedesk.core.itil.cmdb.domain.Relationship;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/{id}")
public class RelationshipViewController extends AbstractRelationshipController {
    public static final String VIEW_VIEW = "/cmdb/relationship/view";
    
    @RequestMapping(method = RequestMethod.GET)
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        Relationship relationship = relationshipService.load(id);
        map.addAttribute("relationship", relationship);
        return VIEW_VIEW;
    }
}
