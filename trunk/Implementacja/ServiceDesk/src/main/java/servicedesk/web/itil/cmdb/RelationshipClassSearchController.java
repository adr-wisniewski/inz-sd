/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.web.base.tree.TreeBuilder;

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

    @Resource(name = "cmdbRelationshipClassTree")
    protected TreeBuilder<?,?> cmdbRelationshipClassTree;
    
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
        map.addAttribute(MODEL_ITEMCLASSES, cmdbRelationshipClassTree.buildTree());
        return VIEW_BROWSE;
    }
}
