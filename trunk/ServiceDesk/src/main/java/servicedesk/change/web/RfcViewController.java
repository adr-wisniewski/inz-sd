/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcState;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.change.domain.helper.RfcChangeTimestampComparator;
import servicedesk.infrastructure.general.spring.SpringSecurityUserDetailsService;

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
    protected RfcChangeTimestampComparator rfcUpdateComparator;
    
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
    
    @ModelAttribute("states")
    RfcState[] populateStates() {
        return RfcState.values();
    }
    
    @RequestMapping(value = "/change/rfc")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/change/rfc/created")
    public String searchCreated(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setCreator(userService.getCurrentUser().getEmployee());
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/change/rfc/unassigned")
    public String searchUnassigned(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setManager(null);
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/change/rfc/managed")
    public String searchManaged(ModelMap map, @ModelAttribute(MODEL_CRITERIA) RfcCriteria criteria) {
        criteria.setManager(userService.getCurrentUser().getEmployee());
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
}
