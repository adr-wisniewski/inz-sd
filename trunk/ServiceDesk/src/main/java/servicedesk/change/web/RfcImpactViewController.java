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
import servicedesk.change.domain.RfcImpact;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/impact")
public class RfcImpactViewController extends AbstractRfcImpactController {
    
    protected static final String VIEW_LIST = "/change/rfc/impact";
    protected static final String VIEW_VIEW = "/change/rfc/impact/view";
    protected static final String MODEL_IMPACTS = "impacts";
    
    @RequestMapping
    public String list(ModelMap map) {
        List<RfcImpact> impacts = service.getAll();
        map.addAttribute(MODEL_IMPACTS, impacts);
        return VIEW_LIST;
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcImpact impact = service.load(id);
        map.addAttribute(impact);
        return VIEW_VIEW;
    }
}
