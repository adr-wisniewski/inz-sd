package servicedesk.editor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import servicedesk.change.dao.RfcImpactDao;
import servicedesk.change.dao.RfcPriorityDao;
import servicedesk.change.dao.RfcResolutionDao;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcResolution;
import servicedesk.change.domain.RfcState;
import servicedesk.change.editor.RfcStateEditor;
import servicedesk.cmdb.dao.ItemClassDao;
import servicedesk.cmdb.dao.ItemDao;
import servicedesk.cmdb.dao.RelationshipClassDao;
import servicedesk.cmdb.dao.UniversalItemClassDao;
import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.UniversalItemClass;

import servicedesk.dao.EmployeeDao;
import servicedesk.dao.RoleDao;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.security.domain.Role;
import servicedesk.em.dao.EventCategoryDao;
import servicedesk.em.dao.EventSignificanceDao;
import servicedesk.em.domain.EventCategory;
import servicedesk.em.domain.EventSignificance;
import servicedesk.em.editor.EventCategoryEditor;
import servicedesk.em.editor.EventSignificanceEditor;
import servicedesk.im.dao.IncidentCategoryDao;
import servicedesk.im.dao.IncidentImpactDao;
import servicedesk.im.dao.IncidentPriorityDao;
import servicedesk.im.dao.IncidentSourceDao;
import servicedesk.im.dao.IncidentStatusDao;
import servicedesk.im.dao.IncidentUrgencyDao;
import servicedesk.im.dao.SupportGroupDao;
import servicedesk.im.domain.IncidentCategory;
import servicedesk.im.domain.IncidentImpact;
import servicedesk.im.domain.IncidentPriority;
import servicedesk.im.domain.IncidentSource;
import servicedesk.im.domain.IncidentStatus;
import servicedesk.im.domain.IncidentUrgency;
import servicedesk.im.domain.SupportGroup;
import servicedesk.im.editor.IncidentCategoryEditor;
import servicedesk.im.editor.IncidentImpactEditor;
import servicedesk.im.editor.IncidentPriorityEditor;
import servicedesk.im.editor.IncidentSourceEditor;
import servicedesk.im.editor.IncidentStatusEditor;
import servicedesk.im.editor.IncidentUrgencyEditor;
import servicedesk.im.editor.SupportGroupEditor;
import servicedesk.infrastructure.general.editor.DomainObjectEditor;
import servicedesk.pm.dao.ProblemCategoryDao;
import servicedesk.pm.dao.ProblemImpactDao;
import servicedesk.pm.dao.ProblemPriorityDao;
import servicedesk.pm.dao.ProblemStatusDao;
import servicedesk.pm.dao.ProblemUrgencyDao;
import servicedesk.pm.dao.SolutionTypeDao;
import servicedesk.pm.domain.ProblemCategory;
import servicedesk.pm.domain.ProblemImpact;
import servicedesk.pm.domain.ProblemPriority;
import servicedesk.pm.domain.ProblemStatus;
import servicedesk.pm.domain.ProblemUrgency;
import servicedesk.pm.domain.SolutionType;
import servicedesk.pm.editor.ProblemCategoryEditor;
import servicedesk.pm.editor.ProblemImpactEditor;
import servicedesk.pm.editor.ProblemPriorityEditor;
import servicedesk.pm.editor.ProblemStatusEditor;
import servicedesk.pm.editor.ProblemUrgencyEditor;
import servicedesk.pm.editor.SolutionTypeEditor;
import servicedesk.rf.dao.RequestCategoryDao;
import servicedesk.rf.dao.RequestPriorityDao;
import servicedesk.rf.dao.RequestStatusDao;
import servicedesk.rf.domain.RequestCategory;
import servicedesk.rf.domain.RequestPriority;
import servicedesk.rf.domain.RequestStatus;
import servicedesk.rf.editor.RequestCategoryEditor;
import servicedesk.rf.editor.RequestPriorityEditor;
import servicedesk.rf.editor.RequestStatusEditor;
import servicedesk.scm.dao.ServiceDao;
import servicedesk.scm.domain.Service;
import servicedesk.scm.editor.ServiceEditor;
import servicedesk.signal.dao.SignalObjectTypeDao;
import servicedesk.signal.dao.SignalReceiverTypeDao;
import servicedesk.signal.dao.SignalSignificanceTypeDao;
import servicedesk.signal.dao.SignalTypeDao;
import servicedesk.signal.domain.SignalObjectType;
import servicedesk.signal.domain.SignalReceiverType;
import servicedesk.signal.domain.SignalSignificanceType;
import servicedesk.signal.domain.SignalType;
import servicedesk.signal.editor.SignalReceiverTypeEditor;
import servicedesk.signal.editor.SignalSignificanceTypeEditor;
import servicedesk.signal.editor.SignalObjectTypeEditor;
import servicedesk.signal.editor.SignalTypeEditor;

@Component
public final class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Autowired
        private IncidentPriorityDao incidentPriorityDao;
	@Autowired
	private IncidentCategoryDao incidentCategoryDao;
	@Autowired
	private IncidentImpactDao incidentImpactDao;
	@Autowired
	private IncidentSourceDao incidentSourceDao;
	@Autowired
	private IncidentStatusDao incidentStatusDao;
	@Autowired
	private IncidentUrgencyDao incidentUrgencyDao;
	@Autowired
	private ProblemPriorityDao problemPriorityDao;
	@Autowired
	private ProblemCategoryDao problemCategoryDao;
	@Autowired
	private ProblemStatusDao problemStatusDao;
	@Autowired
	private ProblemUrgencyDao problemUrgencyDao;
	@Autowired
	private ProblemImpactDao problemImpactDao;
	@Autowired
	private SolutionTypeDao solutionTypeDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private EventSignificanceDao eventTypeDao;
	@Autowired
	private EventCategoryDao eventCategoryDao;
	@Autowired
	private RequestCategoryDao requestCategoryDao;
	@Autowired
	private RequestPriorityDao requestPriorityDao;
	@Autowired
	private RequestStatusDao requestStatusDao;
	@Autowired
	private SupportGroupDao supportGroupDao;
	@Autowired
	private SignalTypeDao signalTypeDao;
	@Autowired
	private SignalObjectTypeDao signalObjectTypeDao;
	@Autowired
	private SignalSignificanceTypeDao signalSignificanceTypeDao;
	@Autowired
	private SignalReceiverTypeDao signalReceiverTypeDao;
	@Autowired
	private ServiceDao serviceDao;
        @Autowired
        private UniversalItemClassDao universalItemClassDao;
        @Autowired
        private ItemDao itemDao;
        @Autowired
        private ItemClassDao itemClassDao;
        @Autowired
        private RelationshipClassDao relationshipClassDao;
        @Autowired
        private RfcPriorityDao rfcPriorityDao;
        @Autowired
        private RfcImpactDao rfcImpactDao;
        @Autowired
        private RfcResolutionDao rfcResolutionDao;
        @Autowired
        private RfcStateEditor rfcStateEditor;
        
	
	public void setIncidentPriorityDao(IncidentPriorityDao incidentPriorityDao) {
		this.incidentPriorityDao = incidentPriorityDao;
	}
	
	public void setIncidentCategoryDao(IncidentCategoryDao incidentCategoryDao) {
		this.incidentCategoryDao = incidentCategoryDao;
	}
	
	public void setIncidentImpactDao(IncidentImpactDao incidentImpactDao) {
		this.incidentImpactDao = incidentImpactDao;
	}

	public void setIncidentSourceDao(IncidentSourceDao incidentSourceDao) {
		this.incidentSourceDao = incidentSourceDao;
	}

	public void setIncidentStatusDao(IncidentStatusDao incidentStatusDao) {
		this.incidentStatusDao = incidentStatusDao;
	}

	public void setIncidentUrgencyDao(IncidentUrgencyDao incidentUrgencyDao) {
		this.incidentUrgencyDao = incidentUrgencyDao;
	}

	public void setProblemPriorityDao(ProblemPriorityDao problemPriorityDao) {
		this.problemPriorityDao = problemPriorityDao;
	}

	public void setProblemCategoryDao(ProblemCategoryDao problemCategoryDao) {
		this.problemCategoryDao = problemCategoryDao;
	}

	public void setProblemStatusDao(ProblemStatusDao problemStatusDao) {
		this.problemStatusDao = problemStatusDao;
	}

	public void setProblemUrgencyDao(ProblemUrgencyDao problemUrgencyDao) {
		this.problemUrgencyDao = problemUrgencyDao;
	}

	public void setProblemImpactDao(ProblemImpactDao problemImpactDao) {
		this.problemImpactDao = problemImpactDao;
	}

	public void setSolutionTypeDao(SolutionTypeDao solutionTypeDao) {
		this.solutionTypeDao = solutionTypeDao;
	}
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}	

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setEventTypeDao(EventSignificanceDao eventTypeDao) {
		this.eventTypeDao = eventTypeDao;
	}
	
	public void setEventCategoryDao(EventCategoryDao eventCategoryDao) {
		this.eventCategoryDao = eventCategoryDao;
	}
	
	public void setRequestCategoryDao(RequestCategoryDao requestCategoryDao) {
		this.requestCategoryDao = requestCategoryDao;
	}

	public void setRequestPriorityDao(RequestPriorityDao requestPriorityDao) {
		this.requestPriorityDao = requestPriorityDao;
	}

	public void setRequestStatusDao(RequestStatusDao requestStatusDao) {
		this.requestStatusDao = requestStatusDao;
	}
	
	public void setSupportGroupDao(SupportGroupDao supportGroupDao) {
		this.supportGroupDao = supportGroupDao;
	}
	
	public void setSignalTypeDao(SignalTypeDao signalTypeDao) {
		this.signalTypeDao = signalTypeDao;
	}
	
	public void setSignalObjectTypeDao(SignalObjectTypeDao signalObjectTypeDao) {
		this.signalObjectTypeDao = signalObjectTypeDao;
	}

	public void setSignalSignificanceTypeDao(
			SignalSignificanceTypeDao signalSignificanceTypeDao) {
		this.signalSignificanceTypeDao = signalSignificanceTypeDao;
	}
	
	public void setSignalReceiverTypeDao(SignalReceiverTypeDao signalReceiverTypeDao) {
		this.signalReceiverTypeDao = signalReceiverTypeDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

        @Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
    	registry.registerCustomEditor(IncidentPriority.class, new IncidentPriorityEditor( incidentPriorityDao ));
    	registry.registerCustomEditor(IncidentCategory.class, new IncidentCategoryEditor( incidentCategoryDao ));
    	registry.registerCustomEditor(IncidentImpact.class, new IncidentImpactEditor( incidentImpactDao ));
    	registry.registerCustomEditor(IncidentSource.class, new IncidentSourceEditor( incidentSourceDao ));
    	registry.registerCustomEditor(IncidentStatus.class, new IncidentStatusEditor( incidentStatusDao ));
    	registry.registerCustomEditor(IncidentUrgency.class, new IncidentUrgencyEditor( incidentUrgencyDao ));
    	registry.registerCustomEditor(SupportGroup.class, new SupportGroupEditor(supportGroupDao));
    	
    	registry.registerCustomEditor(ProblemPriority.class, new ProblemPriorityEditor( problemPriorityDao ));
    	registry.registerCustomEditor(ProblemCategory.class, new ProblemCategoryEditor( problemCategoryDao ));
    	registry.registerCustomEditor(ProblemImpact.class, new ProblemImpactEditor( problemImpactDao ));
    	registry.registerCustomEditor(ProblemStatus.class, new ProblemStatusEditor( problemStatusDao ));
    	registry.registerCustomEditor(ProblemUrgency.class, new ProblemUrgencyEditor( problemUrgencyDao ));
    	registry.registerCustomEditor(SolutionType.class, new SolutionTypeEditor( solutionTypeDao ));
    	
    	registry.registerCustomEditor(Employee.class, new EmployeeEditor(employeeDao));
    	registry.registerCustomEditor(Role.class, new RoleEditor(roleDao));
    	registry.registerCustomEditor(EventCategory.class, new EventCategoryEditor(eventCategoryDao));
    	
    	registry.registerCustomEditor(EventSignificance.class, new EventSignificanceEditor(eventTypeDao));
    	
    	registry.registerCustomEditor(RequestCategory.class, new RequestCategoryEditor(requestCategoryDao));
    	registry.registerCustomEditor(RequestStatus.class, new RequestStatusEditor( requestStatusDao ));
    	registry.registerCustomEditor(RequestPriority.class, new RequestPriorityEditor( requestPriorityDao ));
    	
    	registry.registerCustomEditor(SignalType.class, new SignalTypeEditor( signalTypeDao ));
    	registry.registerCustomEditor(SignalObjectType.class, new SignalObjectTypeEditor( signalObjectTypeDao ));
    	registry.registerCustomEditor(SignalSignificanceType.class, new SignalSignificanceTypeEditor( signalSignificanceTypeDao ));
    	registry.registerCustomEditor(SignalReceiverType.class, new SignalReceiverTypeEditor( signalReceiverTypeDao ));
    	
    	registry.registerCustomEditor(Service.class, new ServiceEditor( serviceDao ));

        registry.registerCustomEditor(UniversalItemClass.class, new DomainObjectEditor<UniversalItemClass>(universalItemClassDao));
        registry.registerCustomEditor(Item.class, new DomainObjectEditor<Item>(itemDao));
        registry.registerCustomEditor(ItemClass.class, new DomainObjectEditor<ItemClass>(itemClassDao));
        registry.registerCustomEditor(RelationshipClass.class, new DomainObjectEditor<RelationshipClass>(relationshipClassDao));
    
        registry.registerCustomEditor(RfcPriority.class, new DomainObjectEditor<RfcPriority>( rfcPriorityDao ));
        registry.registerCustomEditor(RfcImpact.class, new DomainObjectEditor<RfcImpact>( rfcImpactDao ));
        registry.registerCustomEditor(RfcResolution.class, new DomainObjectEditor<RfcResolution>( rfcResolutionDao ));
        registry.registerCustomEditor(RfcState.class, rfcStateEditor);
    }
}
