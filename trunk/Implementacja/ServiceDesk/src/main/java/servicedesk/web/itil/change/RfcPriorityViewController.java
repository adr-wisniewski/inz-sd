/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.change.domain.RfcPriority;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/priority")
public class RfcPriorityViewController extends AbstractRfcPriorityController {
    
    protected static final String VIEW_LIST = "/change/rfc/priority";
    protected static final String VIEW_VIEW = "/change/rfc/priority/view";
    protected static final String MODEL_IMPACTS = "priorities";
    
    @RequestMapping
    public String list(ModelMap map) {
        List<RfcPriority> prioritys = service.getAll();
        map.addAttribute(MODEL_IMPACTS, prioritys);
        return VIEW_LIST;
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcPriority priority = service.load(id);
        map.addAttribute(priority);
        return VIEW_VIEW;
    }
}
