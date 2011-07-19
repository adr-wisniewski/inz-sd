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
import servicedesk.core.itil.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CMDB_ITEMCLASS_VIEW')")
public class ItemClassSearchController extends AbstractItemClassController {
    protected static final String VIEW_SEARCH = "/cmdb/item/class/search";
    protected static final String VIEW_BROWSE = "/cmdb/item/class/browse";
    protected static final String MODEL_CRITERIA = "itemClassCriteria";
    protected static final String MODEL_ITEMCLASSES = "itemClasses";

    @Resource(name = "cmdbUniversalItemClassTree")
    protected TreeBuilder<?,?> cmdbUniversalItemClassTree;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor("true", "false", true));
    }

    @RequestMapping(value = "/search")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) ItemClassCriteria criteria) {
        map.addAttribute(MODEL_ITEMCLASSES, service.search(criteria));
        return VIEW_SEARCH;
    }

    @RequestMapping(value = "/browse")
    public String browse(ModelMap map) {
        map.addAttribute(MODEL_ITEMCLASSES, cmdbUniversalItemClassTree.buildTree());
        return VIEW_BROWSE;
    }
}
