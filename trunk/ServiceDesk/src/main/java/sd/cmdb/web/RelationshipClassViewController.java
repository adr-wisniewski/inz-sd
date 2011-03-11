/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sd.cmdb.domain.RelationshipClass;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CN_RLC_VIE')")
public class RelationshipClassViewController extends RelationshipClassController {
    protected static final String VIEW_GENERAL = "/cmdb/relationship/class";
    protected static final String VIEW_VIEW = "/cmdb/relationship/class/view";

    @RequestMapping(value = "/cmdb/relationship/class")
    public String general() {
        return VIEW_GENERAL;
    }

    @RequestMapping(value = "/cmdb/relationship/class/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer classId) {
        RelationshipClass relationshipClass = service.load(classId);
        map.addAttribute(relationshipClass);
        return VIEW_VIEW;
    }
}
