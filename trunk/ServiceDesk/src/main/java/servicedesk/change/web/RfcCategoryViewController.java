/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicedesk.change.domain.RfcCategory;
import servicedesk.tree.app.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/category")
public class RfcCategoryViewController extends AbstractRfcCategoryController {
    
    protected static final String VIEW_LIST = "/change/rfc/category";
    protected static final String VIEW_VIEW = "/change/rfc/category/view";
    protected static final String MODEL_IMPACTS = "categories";
    
    @RequestMapping
    public String all(ModelMap map) {
        List<RfcCategory> categories = service.getAll();
        map.addAttribute(MODEL_IMPACTS, TreeBuilder.buildTree(categories));
        return VIEW_LIST;
    }
    
    @RequestMapping(params={"id"})
    public String allId(@RequestParam("id") Integer id) {
        return String.format( "redirect:/change/rfc/category/%d", id);
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcCategory category = service.load(id);
        map.addAttribute(category);
        return VIEW_VIEW;
    }
}
