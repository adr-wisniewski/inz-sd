/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;

/**
 *
 * @author Adrian
 */
@Controller
@SessionAttributes({"itemCriteria"})
public class ItemPickerController extends AbstractItemController {

    public static final String VIEW_NAME = "/cmdb/item/picker";
    public static final String CHOOSE_VIEW_NAME = "/cmdb/item/picker/choose";
    
    @RequestMapping(value = "/cmdb/item/picker/class/any/{name}")
    public String showFormNotFiltered(ModelMap map,
                @ModelAttribute("criteria") ItemCriteria criteria,
                @PathVariable("name") String name) {
        
        Iterable<Item> items = service.search(criteria);
        map.addAttribute("itemClass", null);
        map.addAttribute("items", items.iterator());
        map.addAttribute("name", name);
        return VIEW_NAME;
    }
    
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
    
    @RequestMapping(value = "/cmdb/item/picker/class/any/{name}/choose/{id}")
    public String chooseEmployee(ModelMap map,
                @PathVariable("name") String name,
                @PathVariable("id") Integer itemId) {

            Item item = service.get(itemId);

            map.addAttribute("item", item);
            map.addAttribute("name", name);
            return CHOOSE_VIEW_NAME;
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
