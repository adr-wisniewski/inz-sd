/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.change.dao.RfcDao;
import servicedesk.core.itil.change.domain.entity.RfcChange;
import servicedesk.core.itil.change.domain.helper.NullRfc;
import servicedesk.core.itil.change.validator.RfcAddValidator;
import servicedesk.core.itil.change.validator.RfcDeleteValidator;
import servicedesk.core.itil.change.validator.RfcEditValidator;
import servicedesk.infrastructure.interfaces.dao.HistoryDao;
import servicedesk.core.base.history.domain.HistoryRecord;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.common.notification.service.NotificationService;
import servicedesk.infrastructure.search.SearchObject;
import servicedesk.infrastructure.validation.Validated;
import servicedesk.core.itil.change.domain.RfcFactory;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.domain.entity.RfcNotification;
import servicedesk.core.itil.change.domain.entity.RfcState;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcServiceImpl implements RfcService {

    @Autowired
    protected RfcDao dao;
    
    @Autowired
    protected NotificationService notificationService;
    
    @Autowired
    private HistoryDao history;
    
    @Autowired
    private RfcFactory factory;
    
    @Autowired
    protected NullRfc nullRfc;
    
    @Autowired
    protected AuthorizationService authorizationService;
    
    @Autowired
    protected RfcAuthorityService rfcAuthorityService;
    
    @Override
    public List<RfcChange> getChanges(Rfc rfc) {
        List<HistoryRecord<Rfc>> records = history.getChanges(rfc.getId());
        LinkedList<RfcChange> result = new LinkedList<RfcChange>();
        
        Rfc previous = nullRfc;
        for(HistoryRecord<Rfc> record: records) {

            RfcChange change = new RfcChange(record, previous);
            result.addFirst(change);
                  
            previous = record.getObject();
        }
        
        return result;
    }
    
    @Override
    public Rfc load(Integer id) {
        return dao.load(id);
    }

    @Override
    public Rfc get(Integer id) {
        return dao.get(id);
    }
    
    @Override
    public Rfc create() {
        return factory.create();
    }

    @PreAuthorize("hasRole('CHANGE_RFC_ADD')")
    @Validated(validator=RfcAddValidator.class)
    @Override
    public void add(Rfc object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_EDIT')")
    @Validated(validator=RfcEditValidator.class)
    @Override
    public void update(Rfc object, BindingResult bindingResult) {
        dao.merge(object);
        notifyEmployee(object.getManager(), object, RfcNotification.Type.UPDATED);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_DELETE')")
    @Validated(validator=RfcDeleteValidator.class)
    @Override
    public void delete(Rfc object) {
        dao.remove(object);
    }

    @Override
    public List<Rfc> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Rfc> search(SearchObject<Rfc> criteria) {
        return dao.search(criteria);
    }

    protected void notifyEmployee(Employee employee, Rfc object, RfcNotification.Type type) {
        if(employee != null)
            notifyUser(employee.getUser(), object, type);
    }
    
    protected void notifyUser(User user, Rfc object, RfcNotification.Type type) {
        if(user != null) {
            RfcNotification notification = new RfcNotification(
                    user, 
                    authorizationService.getCurrentUser(), 
                    object, 
                    type);
            
            notificationService.add(notification);
        }
    }
    
    protected void notifyAuthority(RfcAuthority authority, Rfc object, RfcNotification.Type type) {
        if(authority != null) {
            for(Employee employee: authority.getMembers()) {
                RfcNotification notification = new RfcNotification(
                        employee.getUser(), 
                        authorizationService.getCurrentUser(), 
                        object, 
                        type);

                notificationService.add(notification);
            }
        }
    }
    
    protected User getUser() {
        return authorizationService.getCurrentUser();
    }

    @Override
    public void updateFlow(Rfc rfc, BindingResult bindingResult) {
        
        Rfc original = load(rfc.getId());
        User user = getUser();
        
        boolean authorized = 
            original.getManager() != null && user.equals(original.getManager().getUser()) 
            || user.equals(original.getAuthor()) 
                && (original.getState().equals(RfcState.NEW) 
                    || original.getState().equals(RfcState.REJECTED)); 
        
        if(authorized) {
            original.setTitle(rfc.getTitle());
            original.setDescription(rfc.getDescription());
            original.setComment(rfc.getComment());
            notifyEmployee(original.getManager(), original, RfcNotification.Type.UPDATED);
        }
    }

    @Override
    @PreAuthorize("hasRole('CHANGE_RFC_MANAGE')")
    public void assignToSelfFlow(Rfc rfc, BindingResult bindingResult) {
        
        Rfc original = load(rfc.getId());
        
        if(original.getManager() == null) {
            original.setManager(authorizationService.getCurrentEmployeeUser().getEmployee());
            original.setComment(rfc.getComment());
            if(original.getState().equals(RfcState.NEW) || original.getState().equals(RfcState.REOPENED))
                original.setState(RfcState.ASSIGNED);
            
            notifyEmployee(original.getManager(), original, RfcNotification.Type.ASSIGNED);
        }
    }

    @Override
    @PreAuthorize("hasRole('CHANGE_RFC_ASSIGN')")
    public void assignFlow(Rfc rfc, BindingResult bindingResult) {
         Rfc original = load(rfc.getId());
         
         if(rfc.getManager() != null && !rfc.getManager().equals(original.getManager())) {
         
             notifyEmployee(original.getManager(), original, RfcNotification.Type.UNASSIGNED);
             
             original.setManager(rfc.getManager());
             original.setComment(rfc.getComment());
             
             if(original.getState().equals(RfcState.NEW) || original.getState().equals(RfcState.REOPENED))
                 original.setState(RfcState.ASSIGNED);

             notifyEmployee(original.getManager(), original, RfcNotification.Type.ASSIGNED);
         }
    }

    @Override
    @PreAuthorize("hasRole('CHANGE_RFC_MANAGE')")
    public void reviewFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        if(getUser().equals(original.getManager().getUser()) && original.getState().equals(RfcState.ASSIGNED)) {
            original.setCategory(rfc.getCategory());
            original.setPriority(rfc.getPriority());
            original.setComment(rfc.getComment());
            original.setState(RfcState.REVIEWED);
            
            notifyEmployee(original.getManager(), original, RfcNotification.Type.REVIEWED);
        }
    }

    @Override
    @PreAuthorize("hasRole('CHANGE_RFC_MANAGE')")
    public void assessFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        if(getUser().equals(original.getManager().getUser()) && original.getState().equals(RfcState.REVIEWED)) {
            original.setCategory(rfc.getCategory());
            original.setPriority(rfc.getPriority());
            original.setImpact(rfc.getImpact());
            original.setAuthority(rfc.getAuthority());
            original.setCab(rfc.getCab());
            original.setComment(rfc.getComment());
            original.setState(RfcState.ASSESSED);
            
            notifyEmployee(original.getManager(), original, RfcNotification.Type.ASSESSED);
            notifyAuthority(rfc.getAuthority(), rfc, RfcNotification.Type.ASSESSED);
        }
    }

    @Override
    public void authorizeFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isAuthorityMember = rfcAuthorityService.isMember(original.getAuthority(), authorizationService.getCurrentEmployeeUser().getEmployee());
        
        if(isAuthorityMember && original.getState().equals(RfcState.ASSESSED)) {
            original.setCategory(rfc.getCategory());
            original.setPriority(rfc.getPriority());
            original.setImpact(rfc.getImpact());
            original.setComment(rfc.getComment());
            original.setState(RfcState.AUTHORIZED);
            notifyEmployee(original.getManager(), original, RfcNotification.Type.AUTHORIZED);
            notifyAuthority(rfc.getCab(), rfc, RfcNotification.Type.AUTHORIZED);
        }
    }

    @Override
    public void scheduleFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isCabMember = rfcAuthorityService.isMember(original.getCab(), authorizationService.getCurrentEmployeeUser().getEmployee());
        
        if(isCabMember && original.getState().equals(RfcState.AUTHORIZED)) {
            original.setBuilder(rfc.getBuilder());
            original.setComment(rfc.getComment());
            original.setState(RfcState.SCHEDULED);
            notifyEmployee(original.getManager(), original, RfcNotification.Type.SCHEDULED);
            notifyEmployee(original.getBuilder(), original, RfcNotification.Type.SCHEDULED);
        }
    }

    @Override
    public void buildFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isBuilder = getUser().equals(original.getBuilder().getUser());
        
        if(isBuilder && original.getState().equals(RfcState.SCHEDULED)) {
            original.setComment(rfc.getComment());
            original.setState(RfcState.BUILT);
            notifyEmployee(original.getManager(), original, RfcNotification.Type.BUILT);
        }
    }

    @Override
    public void closeFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isManager = getUser().equals(original.getManager().getUser());
        
        if(isManager && original.getState().equals(RfcState.BUILT)) {
            original.setPir(rfc.getPir());
            original.setComment(rfc.getComment());
            original.setState(RfcState.CLOSED);
            notifyUser(original.getAuthor(), original, RfcNotification.Type.CLOSED);
        }
    }

    @Override
    public void rejectFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isManager = getUser().equals(original.getManager().getUser());
        boolean isAuthorityMember = rfcAuthorityService.isMember(original.getAuthority(), authorizationService.getCurrentEmployeeUser().getEmployee());
        
        RfcState state = original.getState();
        boolean managerReject = isManager && 
                (state.equals(RfcState.REVIEWED) 
                || state.equals(RfcState.NEW) 
                || state.equals(RfcState.REOPENED)
                || state.equals(RfcState.APPEALED));
        
        boolean authorityReject = isAuthorityMember && state.equals(RfcState.ASSESSED);
        
        if(managerReject || authorityReject) {
            original.setResolution(rfc.getResolution());
            original.setComment(rfc.getComment());
            original.setState(RfcState.REJECTED);
            notifyEmployee(original.getManager(), original, RfcNotification.Type.REJECTED);
            notifyUser(original.getAuthor(), original, RfcNotification.Type.REJECTED);
        }
    }

    @Override
    public void appealFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isAuthor = getUser().equals(original.getAuthor());
        
        if(isAuthor && original.getState().equals(RfcState.REJECTED)) {
            original.setTitle(rfc.getTitle());
            original.setDescription(rfc.getDescription());
            original.setComment(rfc.getComment());
            original.setState(RfcState.APPEALED);
            notifyEmployee(original.getManager(), original, RfcNotification.Type.APPEALED);
        }
    }

    @Override
    public void addCommentFlow(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        original.setComment(rfc.getComment());
        notifyEmployee(original.getManager(), original, RfcNotification.Type.ADDED_COMMENT);
    }

    @Override
    public void acceptAppeal(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        
        boolean isManager = getUser().equals(original.getManager().getUser());
        
        if(isManager && original.getState().equals(RfcState.APPEALED)) {
            original.setResolution(null);
            original.setState(RfcState.REOPENED);
            notifyUser(original.getAuthor(), original, RfcNotification.Type.REOPENED);
        }
    }
}
