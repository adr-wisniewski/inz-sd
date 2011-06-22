/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.core.itil.change.domain.RfcChange;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.itil.change.domain.RfcState;
import servicedesk.core.base.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/{id}")
@SessionAttributes("rfc")
public class RfcEditController extends AbstractRfcController {
    
    protected static final String VIEW_VIEW = "/change/rfc/view";
    protected static final String VIEW_EDIT = "/change/rfc/edit";
    protected static final String MODEL_CHANGES = "changes";
    protected static final String MODEL_PRIORITIES = "priorities";
    protected static final String MODEL_IMPACTS = "impacts";
    protected static final String MODEL_RESOLUTIONS = "resolutions";
    protected static final String MODEL_STATES = "states";
    
    @RequestMapping(value = "", method=RequestMethod.GET)
    public String view(ModelMap model, @PathVariable("id") Integer id) {
        Rfc rfc = service.load(id);
        List<RfcChange> changes = service.getChanges(rfc);
        rfc.setComment(null);             
        
        model.addAttribute(rfc);       
        model.addAttribute(MODEL_CHANGES, changes);
        return VIEW_VIEW;
    }
 
    @RequestMapping(value = "/edit", method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        Rfc rfc = service.load(id);
        List<RfcPriority> priorities = priorityService.getAll();
        List<RfcImpact> impacts = impactService.getAll();
        List<RfcResolution> resolutions = resolutionService.getAll();
        RfcState[] states = RfcState.values();
        
        map.addAttribute(rfc);
        map.addAttribute(MODEL_PRIORITIES, priorities);
        map.addAttribute(MODEL_IMPACTS, impacts);
        map.addAttribute(MODEL_RESOLUTIONS, resolutions);
        map.addAttribute(MODEL_STATES, states);
        return VIEW_EDIT;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute Rfc rfc,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(rfc, bindingResult);
            messages.addMessage("message.change.rfc.edited", rfc.getTitle());
            status.setComplete();
            return String.format("redirect:/change/rfc/%d", rfc.getId());
        } catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/%d/edit", rfc.getId());
        }
    }
    
    
    @RequestMapping(value = "/addComment", method=RequestMethod.POST)
    public String addComment(ModelMap map, 
        @ModelAttribute Rfc rfc, 
        BindingResult bindingResult,
        SessionStatus status) {
         try {
            service.addComment(rfc, bindingResult);
            messages.addMessage("message.change.rfc.commentAdded", rfc.getId(), rfc.getTitle());
            status.setComplete();
            return String.format("redirect:/change/rfc/%d", rfc.getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return "prg:/change/rfc/%d";
        }
    }
}