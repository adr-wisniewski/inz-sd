/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

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
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.cmdb.web.ItemClassBaseController;
import sd.tree.app.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CN_ITC_VIE')")
public class ItemClassSearchController extends ItemClassBaseController {
    protected static final String VIEW_SEARCH = "/cmdb/item/class/search";
    protected static final String VIEW_BROWSE = "/cmdb/item/class/browse";
    protected static final String MODEL_CRITERIA = "itemClassCriteria";
    protected static final String MODEL_ITEMCLASSES = "itemClasses";

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor("true", "false", true));
    }

    @RequestMapping(value = "/search")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) ItemClassCriteria criteria) {

        if(criteria == null)
        {
            criteria = new ItemClassCriteria();
            map.addAttribute(MODEL_CRITERIA, criteria);
        }

        map.addAttribute(MODEL_ITEMCLASSES, itemClassService.search(criteria));
        return VIEW_SEARCH;
    }

    @RequestMapping(value = "/browse")
    public String browse(ModelMap map) {
        List<ItemClass> items = itemClassService.getAll();
        map.addAttribute(MODEL_ITEMCLASSES, TreeBuilder.buildTree(items, ""));
        return VIEW_BROWSE;
    }

    @RequestMapping(value = "/browse", params={"id"})
    public String browseid(@RequestParam(value="id", required=false) String id) {
       return String.format( "redirect:/cmdb/item/class/%s", id);
    }
}
