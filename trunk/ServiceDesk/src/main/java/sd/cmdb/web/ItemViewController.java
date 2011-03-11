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
import sd.cmdb.domain.Item;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CN_ITM_VIE')")
public class ItemViewController extends ItemController {

    protected static final String VIEW_GENERAL = "/cmdb/item/view/general";
    protected static final String VIEW_DETAILS = "/cmdb/item/view/details";

    @RequestMapping(value = "/cmdb/item")
    public String general() {
        return VIEW_GENERAL;
    }

    @RequestMapping(value = "/cmdb/item/{id}")
    public String details(ModelMap map, @PathVariable(value="id") Integer id) {
        Item item = service.load(id);
        map.addAttribute(item);
        return VIEW_DETAILS;
    }
}
