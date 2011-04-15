/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.helper.ItemCriteria;

/**
 *
 * @author Adrian
 */
@Controller
@SessionAttributes({"itemCriteria"})
public class ItemPickerController extends BaseItemController {

    public static final String VIEW_NAME = "/cmdb/item/picker";
    public static final String CHOOSE_VIEW_NAME = "/cmdb/item/picker/choose";

    @RequestMapping(value = "/cmdb/item/picker/class/{classId}/{name}")
    public String showForm(ModelMap map, 
                @ModelAttribute("criteria") ItemCriteria criteria,
                @PathVariable("classId") Integer classId,
                @PathVariable("name") String name) {
        
            ItemClass itemClass = itemClassService.load(classId);

            criteria.setItemClass(itemClass);
            Iterable<Item> items = service.search(criteria);
            
            map.addAttribute("itemClass", itemClass);
            map.addAttribute("items", items.iterator());
            map.addAttribute("name", name);
            return VIEW_NAME;
    }

    @RequestMapping(value = "/cmdb/item/picker/class/{classId}/{name}/choose/{id}")
    public String chooseEmployee(ModelMap map,
                @PathVariable("classId") Integer classId,
                @PathVariable("name") String name,
                @PathVariable("id") Integer itemId) {

            ItemClass itemClass = itemClassService.load(classId);
            Item item = service.get(itemId);
            
            map.addAttribute("itemClass", itemClass);
            map.addAttribute("item", item);
            map.addAttribute("name", name);
            return CHOOSE_VIEW_NAME;
    }

}
