/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.itil.change.domain.RfcState;
import servicedesk.core.itil.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.security.spring.SpringSecurityUserDetailsService;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
@RequestMapping(value = "/change/rfc")
public class RfcViewController extends AbstractRfcController {
    protected static final String VIEW_SEARCH = "/change/rfc";
    protected static final String MODEL_RFCS = "rfcs";
    protected static final String MODEL_CRITERIA = "rfcCriteria";
    
    @Autowired
    protected SpringSecurityUserDetailsService userService;
    
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
    
    @ModelAttribute("resolutions")
    List<RfcResolution> populateResolutions() {
        List<RfcResolution> result = resolutionService.getAll();
        return result;
    }
    
    @ModelAttribute("states")
    RfcState[] populateStates() {
        return RfcState.values();
    }
    
    @RequestMapping(value = "")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/created")
    public String searchCreated(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setCreator(userService.getCurrentUser().getEmployee());
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/unassigned")
    public String searchUnassigned(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setManager(null);
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/managed")
    public String searchManaged(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setManager(userService.getCurrentUser().getEmployee());
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
}
