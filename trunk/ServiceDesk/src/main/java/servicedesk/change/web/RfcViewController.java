/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcState;
import servicedesk.change.domain.helper.RfcCriteria;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcViewController extends AbstractRfcController {
    protected static final String VIEW_SEARCH = "/change/rfc";
    protected static final String VIEW_VIEW = "/change/rfc/view";
    protected static final String MODEL_RFCS = "rfcs";
    protected static final String MODEL_CRITERIA = "rfcCriteria";
    
    @ModelAttribute("priorities")
    List<RfcPriority> populatePriorities() {
        List<RfcPriority> result = priorityService.getAll();
        return result;
    }
    
    @ModelAttribute("impacts")
    List<RfcImpact> populateImpacts() {
        List<RfcImpact> result = impactService.getAll();
        return result;
    }
    
    @ModelAttribute("states")
    RfcState[] populateStates() {
        return RfcState.values();
    }
    
    @RequestMapping(value = "/change/rfc")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/change/rfc/{id}")
    public String general(ModelMap model, @PathVariable("id") Integer id) {
        Rfc rfc = service.get(id);
        model.addAttribute(rfc);
        return VIEW_VIEW;
    }
}
