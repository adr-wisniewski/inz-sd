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
import org.springframework.web.bind.annotation.RequestMethod;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/item/class/*")
@PreAuthorize("hasRole('CN_ITC_VIE')")
public class ItemClassViewController extends ItemClassBaseController {
    protected static final String VIEW_MAIN = "/cmdb/item/class";
    protected static final String VIEW_VIEW = "/cmdb/item/class/view";
    protected static final String MODEL_ITEMCLASS = "itemClass";

    @RequestMapping(method = RequestMethod.GET)
    public String general() {
        return VIEW_MAIN;
    }

    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") ItemClass itemClass) {
        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        return VIEW_VIEW;
    }
}
