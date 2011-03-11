package sd.editor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.editor.UniversalItemClassEditor;

import sd.dao.EmployeeDao;
import sd.dao.RoleDao;
import sd.domain.Employee;
import sd.domain.Role;
import sd.em.dao.EventCategoryDao;
import sd.em.dao.EventSignificanceDao;
import sd.em.domain.EventCategory;
import sd.em.domain.EventSignificance;
import sd.em.editor.EventCategoryEditor;
import sd.em.editor.EventSignificanceEditor;
import sd.im.dao.IncidentCategoryDao;
import sd.im.dao.IncidentImpactDao;
import sd.im.dao.IncidentPriorityDao;
import sd.im.dao.IncidentSourceDao;
import sd.im.dao.IncidentStatusDao;
import sd.im.dao.IncidentUrgencyDao;
import sd.im.dao.SupportGroupDao;
import sd.im.domain.IncidentCategory;
import sd.im.domain.IncidentImpact;
import sd.im.domain.IncidentPriority;
import sd.im.domain.IncidentSource;
import sd.im.domain.IncidentStatus;
import sd.im.domain.IncidentUrgency;
import sd.im.domain.SupportGroup;
import sd.im.editor.IncidentCategoryEditor;
import sd.im.editor.IncidentImpactEditor;
import sd.im.editor.IncidentPriorityEditor;
import sd.im.editor.IncidentSourceEditor;
import sd.im.editor.IncidentStatusEditor;
import sd.im.editor.IncidentUrgencyEditor;
import sd.im.editor.SupportGroupEditor;
import sd.pm.dao.ProblemCategoryDao;
import sd.pm.dao.ProblemImpactDao;
import sd.pm.dao.ProblemPriorityDao;
import sd.pm.dao.ProblemStatusDao;
import sd.pm.dao.ProblemUrgencyDao;
import sd.pm.dao.SolutionTypeDao;
import sd.pm.domain.ProblemCategory;
import sd.pm.domain.ProblemImpact;
import sd.pm.domain.ProblemPriority;
import sd.pm.domain.ProblemStatus;
import sd.pm.domain.ProblemUrgency;
import sd.pm.domain.SolutionType;
import sd.pm.editor.ProblemCategoryEditor;
import sd.pm.editor.ProblemImpactEditor;
import sd.pm.editor.ProblemPriorityEditor;
import sd.pm.editor.ProblemStatusEditor;
import sd.pm.editor.ProblemUrgencyEditor;
import sd.pm.editor.SolutionTypeEditor;
import sd.rf.dao.RequestCategoryDao;
import sd.rf.dao.RequestPriorityDao;
import sd.rf.dao.RequestStatusDao;
import sd.rf.domain.RequestCategory;
import sd.rf.domain.RequestPriority;
import sd.rf.domain.RequestStatus;
import sd.rf.editor.RequestCategoryEditor;
import sd.rf.editor.RequestPriorityEditor;
import sd.rf.editor.RequestStatusEditor;
import sd.scm.dao.ServiceDao;
import sd.scm.domain.Service;
import sd.scm.editor.ServiceEditor;
import sd.signal.dao.SignalObjectTypeDao;
import sd.signal.dao.SignalReceiverTypeDao;
import sd.signal.dao.SignalSignificanceTypeDao;
import sd.signal.dao.SignalTypeDao;
import sd.signal.domain.SignalObjectType;
import sd.signal.domain.SignalReceiverType;
import sd.signal.domain.SignalSignificanceType;
import sd.signal.domain.SignalType;
import sd.signal.editor.SignalReceiverTypeEditor;
import sd.signal.editor.SignalSignificanceTypeEditor;
import sd.signal.editor.SignalObjectTypeEditor;
import sd.signal.editor.SignalTypeEditor;

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
        private UniversalItemClassEditor itemClassEditor;
	
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

        registry.registerCustomEditor(UniversalItemClass.class, itemClassEditor);
    }
}
