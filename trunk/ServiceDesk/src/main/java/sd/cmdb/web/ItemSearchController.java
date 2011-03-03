/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.UniversalItemClass;
import sd.tree.app.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/*")
@PreAuthorize("hasRole('CN_ITM_VIE')")
public class ItemSearchController extends ItemController {

    protected static final String PATH_CLASSID = "classid";
    protected static final String MODEL_ITEMCLASS = "itemClass";
    protected static final String MODEL_ITEMCLASSES = "itemClasses";
    protected static final String MODEL_ITEMS = "items";
    protected static final String VIEW_BROWSE_TREE = "/cmdb/item/browse/tree";
    protected static final String VIEW_BROWSE_CATEGORY = "/cmdb/item/browse/category";

    @RequestMapping(value = "/browse")
    public String browse(ModelMap map) {
        List<ItemClass> items = itemClassService.getAll();
        map.addAttribute(MODEL_ITEMCLASSES, TreeBuilder.buildTree(items, ""));
        return VIEW_BROWSE_TREE;
    }

    @RequestMapping(value = "/browse", params={"id"})
    public String browseId(@RequestParam("id") Integer id) {
        ItemClass itemClass = itemClassService.load(id);
        return String.format( "redirect:/cmdb/item/browse/%d", itemClass.getId());
    }

    @RequestMapping(value = "/browse/{classid}")
    public String browseName(ModelMap map, @PathVariable(PATH_CLASSID) Integer id) {
        ItemClass itemClass = itemClassService.load(id);
        List<Item> items = service.getByClass(itemClass);

        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        map.addAttribute(MODEL_ITEMS, items);
        
        return VIEW_BROWSE_CATEGORY;
    }
}
