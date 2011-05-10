/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import servicedesk.infrastructure.general.domain.HistoryRecord;
import servicedesk.infrastructure.general.domain.Timestamped;
import servicedesk.infrastructure.general.domain.TimestampedComparator;
import servicedesk.infrastructure.general.spring.SpringSecurityUserAdapter;
import servicedesk.infrastructure.security.domain.User;

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
    protected static final String MODEL_HISTORY = "history";
    
    @Autowired
    protected TimestampedComparator timestampedComparator;
    
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
        criteria.setCreator(getCurrentUser().getEmployee());
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
        criteria.setManager(getCurrentUser().getEmployee());
        criteria.setAllowEmptyQueries(true);
        map.addAttribute(MODEL_RFCS, service.search(criteria));
        return VIEW_SEARCH;
    }
    
    @RequestMapping(value = "/change/rfc/{id}")
    public String general(ModelMap model, @PathVariable("id") Integer id) {
        Rfc rfc = service.load(id);
        List<HistoryRecord<Rfc>> changes = service.getChanges(id);
        
        List<Timestamped> history = new LinkedList<Timestamped>();
        history.addAll(rfc.getComments());
        history.addAll(changes);
        Collections.sort(history, timestampedComparator);
             
        model.addAttribute(rfc);       
        model.addAttribute(MODEL_HISTORY, history);
        return VIEW_VIEW;
    }
    
    protected User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof SpringSecurityUserAdapter))
            throw new IllegalStateException("AuthoredDomainObjectEventListener requires use of SpringSecurityUserAdapter as authentication");

        User user = ((SpringSecurityUserAdapter)principal).getUser();
        return user;
    }
}
