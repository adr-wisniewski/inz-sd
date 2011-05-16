/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import java.util.List;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.tree.app.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/relationship/class/*")
@PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_VIEW')")
public class RelationshipClassSearchController extends AbstractRelationshipClassController {
    protected static final String VIEW_SEARCH = "/cmdb/relationship/class/search";
    protected static final String VIEW_BROWSE = "/cmdb/relationship/class/browse";
    protected static final String MODEL_CRITERIA = "relationshipClassCriteria";
    protected static final String MODEL_ITEMCLASSES = "relationshipClasses";

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor("true", "false", true));
    }

    @RequestMapping(value = "/search")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RelationshipClassCriteria criteria) {
        map.addAttribute(MODEL_ITEMCLASSES, service.search(criteria));
        return VIEW_SEARCH;
    }

    @RequestMapping(value = "/browse")
    public String browse(ModelMap map) {
        List<RelationshipClass> items = service.getAll();
        map.addAttribute(MODEL_ITEMCLASSES, TreeBuilder.buildTree(items));
        return VIEW_BROWSE;
    }

    @RequestMapping(value = "/browse", params={"id"})
    public String browseid(@RequestParam("id") Integer id) {
       return String.format( "redirect:/cmdb/relationship/class/%d", id);
    }
}
