package servicedesk.web.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import servicedesk.core.itil.change.dao.RfcCategoryDao;
import servicedesk.core.itil.change.dao.RfcImpactDao;
import servicedesk.core.itil.change.dao.RfcPriorityDao;
import servicedesk.core.itil.change.dao.RfcResolutionDao;
import servicedesk.core.itil.change.domain.RfcCategory;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.itil.change.domain.RfcState;
import servicedesk.core.itil.cmdb.dao.ItemClassDao;
import servicedesk.core.itil.cmdb.dao.ItemDao;
import servicedesk.core.itil.cmdb.dao.RelationshipClassDao;
import servicedesk.core.itil.cmdb.dao.UniversalItemClassDao;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;

import servicedesk.core.hr.dao.EmployeeDao;
import servicedesk.infrastructure.security.dao.RoleDao;
import servicedesk.core.hr.domain.Employee;
import servicedesk.core.hr.editor.EmployeeEditor;
import servicedesk.infrastructure.security.editor.RoleEditor;
import servicedesk.infrastructure.security.domain.Role;
import servicedesk.core.base.em.dao.EventCategoryDao;
import servicedesk.core.base.em.dao.EventSignificanceDao;
import servicedesk.core.base.em.domain.EventCategory;
import servicedesk.core.base.em.domain.EventSignificance;
import servicedesk.core.base.em.editor.EventCategoryEditor;
import servicedesk.core.base.em.editor.EventSignificanceEditor;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.dao.IncidentImpactDao;
import servicedesk.core.itil.im.dao.IncidentPriorityDao;
import servicedesk.core.itil.im.dao.IncidentSourceDao;
import servicedesk.core.itil.im.dao.IncidentStatusDao;
import servicedesk.core.itil.im.dao.IncidentUrgencyDao;
import servicedesk.core.itil.im.dao.SupportGroupDao;
import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.core.itil.im.domain.IncidentImpact;
import servicedesk.core.itil.im.domain.IncidentPriority;
import servicedesk.core.itil.im.domain.IncidentSource;
import servicedesk.core.itil.im.domain.IncidentStatus;
import servicedesk.core.itil.im.domain.IncidentUrgency;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.im.editor.IncidentCategoryEditor;
import servicedesk.core.itil.im.editor.IncidentImpactEditor;
import servicedesk.core.itil.im.editor.IncidentPriorityEditor;
import servicedesk.core.itil.im.editor.IncidentSourceEditor;
import servicedesk.core.itil.im.editor.IncidentStatusEditor;
import servicedesk.core.itil.im.editor.IncidentUrgencyEditor;
import servicedesk.core.itil.im.editor.SupportGroupEditor;
import servicedesk.core.itil.pm.dao.ProblemCategoryDao;
import servicedesk.core.itil.pm.dao.ProblemImpactDao;
import servicedesk.core.itil.pm.dao.ProblemPriorityDao;
import servicedesk.core.itil.pm.dao.ProblemStatusDao;
import servicedesk.core.itil.pm.dao.ProblemUrgencyDao;
import servicedesk.core.itil.pm.dao.SolutionTypeDao;
import servicedesk.core.itil.pm.domain.ProblemCategory;
import servicedesk.core.itil.pm.domain.ProblemImpact;
import servicedesk.core.itil.pm.domain.ProblemPriority;
import servicedesk.core.itil.pm.domain.ProblemStatus;
import servicedesk.core.itil.pm.domain.ProblemUrgency;
import servicedesk.core.itil.pm.domain.SolutionType;
import servicedesk.core.itil.pm.editor.ProblemCategoryEditor;
import servicedesk.core.itil.pm.editor.ProblemImpactEditor;
import servicedesk.core.itil.pm.editor.ProblemPriorityEditor;
import servicedesk.core.itil.pm.editor.ProblemStatusEditor;
import servicedesk.core.itil.pm.editor.ProblemUrgencyEditor;
import servicedesk.core.itil.pm.editor.SolutionTypeEditor;
import servicedesk.core.itil.rf.dao.RequestCategoryDao;
import servicedesk.core.itil.rf.dao.RequestPriorityDao;
import servicedesk.core.itil.rf.dao.RequestStatusDao;
import servicedesk.core.itil.rf.domain.RequestCategory;
import servicedesk.core.itil.rf.domain.RequestPriority;
import servicedesk.core.itil.rf.domain.RequestStatus;
import servicedesk.core.itil.rf.editor.RequestCategoryEditor;
import servicedesk.core.itil.rf.editor.RequestPriorityEditor;
import servicedesk.core.itil.rf.editor.RequestStatusEditor;
import servicedesk.core.itil.scm.dao.ServiceDao;
import servicedesk.core.itil.scm.domain.Service;
import servicedesk.core.itil.scm.editor.ServiceEditor;
import servicedesk.core.base.signal.dao.SignalObjectTypeDao;
import servicedesk.core.base.signal.dao.SignalReceiverTypeDao;
import servicedesk.core.base.signal.dao.SignalSignificanceTypeDao;
import servicedesk.core.base.signal.dao.SignalTypeDao;
import servicedesk.core.base.signal.domain.SignalObjectType;
import servicedesk.core.base.signal.domain.SignalReceiverType;
import servicedesk.core.base.signal.domain.SignalSignificanceType;
import servicedesk.core.base.signal.domain.SignalType;
import servicedesk.core.base.signal.editor.SignalReceiverTypeEditor;
import servicedesk.core.base.signal.editor.SignalSignificanceTypeEditor;
import servicedesk.core.base.signal.editor.SignalObjectTypeEditor;
import servicedesk.core.base.signal.editor.SignalTypeEditor;
import servicedesk.infrastructure.editor.BeanPropertyEditor;
import servicedesk.infrastructure.editor.DomainObjectEditor;
import servicedesk.infrastructure.editor.EnumOrdinalEditor;
import servicedesk.web.base.tree.TreeBuilder;

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
        private RfcCategoryDao rfcCategoryDao;
        @Autowired
        private RfcResolutionDao rfcResolutionDao;

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
        registry.registerCustomEditor(RfcCategory.class, new DomainObjectEditor<RfcCategory>( rfcCategoryDao ));
        registry.registerCustomEditor(RfcState.class, new EnumOrdinalEditor<RfcState>(RfcState.class));
    }
}
