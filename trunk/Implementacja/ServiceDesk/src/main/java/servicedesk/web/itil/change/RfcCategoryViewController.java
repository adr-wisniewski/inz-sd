/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.web.base.tree.TreeBuilder;

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
    
    @Resource(name="rfcCategoriesTree")
    protected TreeBuilder<?,?> rfcCategoriesTree;
    
    @RequestMapping
    public String all(ModelMap map) {
        map.addAttribute(MODEL_IMPACTS, rfcCategoriesTree.buildTree());
        return VIEW_LIST;
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcCategory category = service.load(id);
        map.addAttribute(category);
        return VIEW_VIEW;
    }
}
