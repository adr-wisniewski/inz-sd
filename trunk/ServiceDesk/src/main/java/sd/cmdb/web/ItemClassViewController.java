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
import sd.cmdb.domain.UniversalItemClass;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CN_ITC_VIE')")
public class ItemClassViewController extends ItemClassController {
    protected static final String VIEW_GENERAL = "/cmdb/item/class";
    protected static final String VIEW_VIEW = "/cmdb/item/class/view";
    protected static final String MODEL_ITEMCLASS = "universalItemClass";

    @RequestMapping(value = "/cmdb/item/class")
    public String general() {
        return VIEW_GENERAL;
    }

    @RequestMapping(value = "/cmdb/item/class/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer classId) {
        UniversalItemClass itemClass = service.load(classId);
        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        return VIEW_VIEW;
    }
}
