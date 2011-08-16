/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.ClientUser;
import servicedesk.core.base.security.domain.CooperantUser;
import servicedesk.core.base.security.domain.EmployeeUser;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.domain.UserVisitor;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.domain.entity.RfcChange;
import servicedesk.core.itil.change.domain.entity.RfcImpact;
import servicedesk.core.itil.change.domain.entity.RfcPriority;
import servicedesk.core.itil.change.domain.entity.RfcResolution;
import servicedesk.core.itil.change.domain.entity.RfcState;
import servicedesk.core.itil.change.service.RfcAuthorityService;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.core.itil.cmdb.service.RelationshipService;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/{id}")
@SessionAttributes("rfc")
public class RfcEditController extends AbstractRfcController {
    
    @Autowired
    protected RelationshipService relationshipService;
    
    @Autowired
    protected AuthorizationService authorizationService;
    
    @Autowired
    protected RfcAuthorityService rfcAutorityService;
    
    protected UserTypeDependantInfoPicker infoPicker = new UserTypeDependantInfoPicker();
    
    protected static final String VIEW_VIEW = "/change/rfc/view";
    protected static final String VIEW_EDIT = "/change/rfc/edit";
    protected static final String MODEL_CHANGES = "changes";
    protected static final String MODEL_PRIORITIES = "priorities";
    protected static final String MODEL_IMPACTS = "impacts";
    protected static final String MODEL_RESOLUTIONS = "resolutions";
    protected static final String MODEL_STATES = "states";
    protected static final String MODEL_AUTHORITIES = "authorities";
    protected static final String MODEL_CABS = "cabs";
    
    @RequestMapping(value = "", method=RequestMethod.GET)
    public String view(ModelMap model, @PathVariable("id") Integer id) {
        Rfc rfc = service.load(id);
        
        List<RfcPriority> priorities = priorityService.getAll();
        List<RfcImpact> impacts = impactService.getAll();
        List<RfcResolution> resolutions = resolutionService.getAll();
        List<RfcChange> changes = service.getChanges(rfc);
        List<Relationship> relationships = relationshipService.forItem(rfc.getRfcItem());
        List<RfcAuthority> authorities = rfcAutorityService.getAllForRfc(rfc);
        List<RfcAuthority> cabs = rfcAutorityService.getAllCabsForRfc(rfc);
        
        rfc.setComment(null);   
   
        User user = authorizationService.getCurrentUser();
        user.accept(infoPicker, new UTDIPContext(model, rfc));
        
        model.addAttribute("rfc", rfc);       
        model.addAttribute("relationships", relationships);
        model.addAttribute(MODEL_CHANGES, changes);
        model.addAttribute(MODEL_PRIORITIES, priorities);
        model.addAttribute(MODEL_IMPACTS, impacts);
        model.addAttribute(MODEL_RESOLUTIONS, resolutions);
        model.addAttribute(MODEL_AUTHORITIES, authorities);
        model.addAttribute(MODEL_CABS, cabs);
        return VIEW_VIEW;
    }
    
    @RequestMapping(value="", method=RequestMethod.POST, params="action")
    public String addComment(ModelMap model, @PathVariable("id") Integer id, 
        @RequestParam(value="action") String action, @ModelAttribute Rfc rfc, 
        BindingResult bindingResult, SessionStatus status) {
        
        try {
            
            String messageCode;
            
            if(action.equals("update")) {
                service.updateFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.updated";
            } else if (action.equals("assignToSelf")) {
                service.assignToSelfFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.assignedToSelf";
            } else if (action.equals("assign")) {
                service.assignFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.assigned";
            } else if (action.equals("review")) {
                service.reviewFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.reviewed";
            } else if (action.equals("assess")) {
                service.assessFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.assessed";
            } else if (action.equals("authorize")) {
                service.authorizeFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.authorized";
            } else if (action.equals("schedule")) {
                service.scheduleFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.scheduled";
            } else if (action.equals("build")) {
                service.buildFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.built";
            } else if (action.equals("close")) {
                service.closeFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.closed";
            } else if (action.equals("reject")) {
                service.rejectFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.rejected";
            } else if (action.equals("appeal")) {
                service.appealFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.appealed";
            } else if (action.equals("addComment")) {
                service.addCommentFlow(rfc, bindingResult);
                messageCode = "message.change.rfc.addedComment";
            } else if (action.equals("acceptAppeal")) {
                service.acceptAppeal(rfc, bindingResult);
                messageCode = "message.change.rfc.acceptedAppeal";
            } else {
                throw new IllegalArgumentException("Action " + action + " is illlegal");
            }
            
            messages.addMessage(messageCode, rfc.getId(), rfc.getTitle());
            status.setComplete();
            return String.format("redirect:/change/rfc/%d", rfc.getId());
        } catch(BusinessConstraintViolationException ex) {
            model.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/change/rfc/%d", rfc.getId());
        }
        
    }
 
    @RequestMapping(value = "/edit", method=RequestMethod.GET)
    public String editGet(ModelMap map, @PathVariable("id") Integer id) {
        Rfc rfc = service.load(id);
        List<RfcPriority> priorities = priorityService.getAll();
        List<RfcImpact> impacts = impactService.getAll();
        List<RfcResolution> resolutions = resolutionService.getAll();
        List<RfcAuthority> authorities = rfcAutorityService.getAllForRfc(rfc);
        List<RfcAuthority> cabs = rfcAutorityService.getAllCabsForRfc(rfc);
        RfcState[] states = RfcState.values();
        
        map.addAttribute("rfc", rfc);
        map.addAttribute(MODEL_PRIORITIES, priorities);
        map.addAttribute(MODEL_IMPACTS, impacts);
        map.addAttribute(MODEL_RESOLUTIONS, resolutions);
        map.addAttribute(MODEL_STATES, states);
        map.addAttribute(MODEL_AUTHORITIES, authorities);
        map.addAttribute(MODEL_CABS, cabs);
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
    
    protected static class UTDIPContext {
        
        public UTDIPContext(ModelMap model, Rfc rfc) {
            this.model = model;
            this.rfc = rfc;
        }
        
        public ModelMap model;
        public Rfc rfc;
    }
    
    // the return type is not used here
    protected class UserTypeDependantInfoPicker implements UserVisitor<Integer, UTDIPContext> {

        @Override
        public Integer visit(ClientUser client, UTDIPContext context) {
            checkAuthor(client, context);
            return null; // the return type is not used here
        }

        @Override
        public Integer visit(CooperantUser cooperant, UTDIPContext context) {
            checkAuthor(cooperant, context);
            return null; // the return type is not used here
        }

        @Override
        public Integer visit(EmployeeUser employeeUser, UTDIPContext context) {
            
            checkAuthor(employeeUser, context);
            
            Employee employee = employeeUser.getEmployee();
            
            boolean isManager = employee.equals(context.rfc.getManager());
            boolean isBuilder = employee.equals(context.rfc.getBuilder());
            boolean isCabMember = rfcAutorityService.isMember(context.rfc.getCab(), employee);
            boolean isAuthority = rfcAutorityService.isMember(context.rfc.getAuthority(), employee); 

            context.model.addAttribute("isManager", isManager); 
            context.model.addAttribute("isBuilder", isBuilder); 
            context.model.addAttribute("isCabMember", isCabMember); 
            context.model.addAttribute("isAuthority", isAuthority); 
            
            return null; // the return type is not used here
        }
        
        protected void checkAuthor(User user, UTDIPContext context) {
            boolean isAuthor = user.equals(context.rfc.getAuthor());
            context.model.addAttribute("isAuthor", isAuthor); 
        }
    } 
}
