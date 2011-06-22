/**
 * 
 */
package servicedesk.core.itil.im.service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.base.history.domain.HistoryAction;
import servicedesk.core.base.history.domain.HistoryActionType;
import servicedesk.core.base.history.domain.HistoryActions;
import servicedesk.core.base.history.service.HistoryBuilderService;
import servicedesk.core.base.event.service.GenericEventService;
import servicedesk.core.itil.im.app.IncidentSearchCriteria;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.dao.IncidentDao;
import servicedesk.core.itil.im.dao.IncidentHistoryDao;
import servicedesk.core.itil.im.dao.IncidentImpactDao;
import servicedesk.core.itil.im.dao.IncidentPriorityDao;
import servicedesk.core.itil.im.dao.IncidentSourceDao;
import servicedesk.core.itil.im.dao.IncidentStatusDao;
import servicedesk.core.itil.im.dao.IncidentUrgencyDao;
import servicedesk.core.itil.im.dao.SupportGroupDao;
import servicedesk.core.itil.im.domain.Incident;
import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.core.itil.im.domain.IncidentHistory;
import servicedesk.core.itil.im.domain.IncidentImpact;
import servicedesk.core.itil.im.domain.IncidentPriority;
import servicedesk.core.itil.im.domain.IncidentSource;
import servicedesk.core.itil.im.domain.IncidentStatus;
import servicedesk.core.itil.im.domain.IncidentUrgency;
import servicedesk.core.itil.im.domain.SupportGroup;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Service
@Transactional
public class IncidentServiceImpl extends GenericEventService<Incident, IncidentDao, IncidentSearchCriteria> implements IncidentService {
	private static Logger logger = Logger.getLogger(IncidentServiceImpl.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentCategoryDao incidentCategoryDao;

	@Autowired
	private IncidentHistoryDao incidentHistoryDao;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentImpactDao incidentImpactDao;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentPriorityDao incidentPriorityDao;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentSourceDao incidentSourceDao;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentStatusDao incidentStatusDao;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentUrgencyDao incidentUrgencyDao;
	
	@Autowired
	private SupportGroupDao supportGroupDao;
	
	@Override
	public void add(Incident incident) {	
		incident.setStatus(IncidentStatus.OPEN);
		if(incident.getSource() == null) {
			incident.setSource(IncidentSource.WEB_FORM);
		}
		incident.setLastEditBy(employeeService.getCurrentUser());
		super.add(incident);
	}

	@Override
	public void edit(Incident incident) {
		if(incident.getStatus().equals(IncidentStatus.RESOLVED)) {
			incident.setResolutionDate(new Date());
		}
		else if(incident.getStatus().equals(IncidentStatus.CLOSED)) {
			incident.setClosureDate(new Date());
		}
		incident.setLastEditBy(employeeService.getCurrentUser());
		incident.refreshTargetResolutionDate();
		
		super.edit(incident);
	}

	private HistoryActions getActions(IncidentHistory before, IncidentHistory after) {
		HistoryActions actions = new HistoryActions();
		actions.setEmployee(after.getEmployee());
		actions.setEventDate(after.getChangeDate());
		
		HistoryBuilderService hb = new HistoryBuilderService(actions);
		hb.addAttribute(before.getStatus(), after.getStatus(), HistoryActionType.STATUS);
		hb.addAttribute(before.getDescription(), after.getDescription(), HistoryActionType.DESCRIPTION);
		hb.addAttribute(before.getResolution(), after.getResolution(), HistoryActionType.RESOLUTION);
		hb.addAttribute(before.getSubject(), after.getSubject(), HistoryActionType.SUBJECT);
		hb.addAttribute(before.getCategory(), after.getCategory(), HistoryActionType.CATEGORY);
		hb.addAttribute(before.getClosureDate(), after.getClosureDate(), HistoryActionType.CLOSURE_DATE);
		hb.addAttribute(before.getImpact(), after.getImpact(), HistoryActionType.IMPACT);
		hb.addAttribute(before.getPriority(), after.getPriority(), HistoryActionType.PRIORITY);
		hb.addAttribute(before.getResolutionDate(), after.getResolutionDate(), HistoryActionType.RESOLUTION_DATE);
		hb.addAttribute(before.getTargetResolutionDate(), after.getTargetResolutionDate(), HistoryActionType.TARGET_RESOLUTION_DATE);
		hb.addAttribute(before.getUrgency(), after.getUrgency(), HistoryActionType.URGENCY);
		hb.addAttribute(before.getSupportGroupMember(), after.getSupportGroupMember(), HistoryActionType.STAFF_MEMBER);
		hb.addAttribute(before.getSupportGroup(), after.getSupportGroup(), HistoryActionType.SUPPORT_GROUP);
                hb.addAttribute(before.getService(), after.getService(), HistoryActionType.SERVICE);
		
		return actions;
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllCategories()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentCategory> getAllCategories() {
		return incidentCategoryDao.getAll();
	}

    @Override
	public List<SupportGroup> getAllGroups() {
		return supportGroupDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllImpacts()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentImpact> getAllImpacts() {
		return incidentImpactDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllPriorities()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentPriority> getAllPriorities() {
		return incidentPriorityDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllSources()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentSource> getAllSources() {
		return incidentSourceDao.getAll();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllStatuses()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentStatus> getAllStatuses() {
		return incidentStatusDao.getAll();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllUrgencies()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<IncidentUrgency> getAllUrgencies() {
		return incidentUrgencyDao.getAll();
	}

    @Override
	public IncidentSearchCriteria getCurrentUserClosedIncidentsSearchCriteria() {
		IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setAuthor(employeeService.getCurrentUser());
		searchCriteria.setStatus(IncidentStatus.CLOSED);
		
		return searchCriteria;
	}

	/**
	 * (non-Javadoc)
	 * @see servicedesk.im.service.IncidentService#getCurrentUserOpenIncidentsSearchCriteria()
	 */
    @Override
	public IncidentSearchCriteria getCurrentUserOpenIncidentsSearchCriteria() {
		IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setAuthor(employeeService.getCurrentUser());
		searchCriteria.setStatus(IncidentStatus.OPEN);
		
		return searchCriteria;
	}

	private HistoryActions getFirstActions(IncidentHistory ih) {
		HistoryActions creation = new HistoryActions();
		creation.setEmployee(ih.getEmployee());
		creation.setEventDate(ih.getChangeDate());
		creation.addAction(new HistoryAction("-", "-", HistoryActionType.CREATION));
		
		return creation;
	}

    @Override
	public SupportGroup getGroupById(Integer groupId) {
		return supportGroupDao.get(groupId);
	}
	
    @Override
	public List<HistoryActions> getHistory(Incident incident) {
		Iterator<IncidentHistory> it = incidentHistoryDao.findIncidentHistory(incident.getId()).iterator();
		List<HistoryActions> actions = new LinkedList<HistoryActions>();
		
		IncidentHistory before = it.next();
		actions.add(getFirstActions(before));
		while(it.hasNext()) {
			IncidentHistory after = it.next();
			HistoryActions ha = getActions(before, after);
                        if(!ha.getActions().isEmpty()) {
                            actions.add(ha);
                        }
			before = after;
		}
		
		return actions;
	}

	public IncidentPriorityDao getIncidentPriorityDao() {
		return incidentPriorityDao;
	}

	/** 
	 * /**
	 *  * @param incidentCategoryDao the incidentCategoryDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentCategoryDao(IncidentCategoryDao incidentCategoryDao) {
		this.incidentCategoryDao = incidentCategoryDao;
	}

	/** 
	 * /**
	 *  * @param incidentDao the incidentDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	public void setIncidentDao(IncidentDao incidentDao) {
		this.eventDao = incidentDao;
	}

	public void setIncidentHistoryDao(IncidentHistoryDao incidentHistoryDao) {
		this.incidentHistoryDao = incidentHistoryDao;
	}

	/** 
	 * /**
	 *  * @param incidentImpactDao the incidentImpactDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentImpactDao(IncidentImpactDao incidentImpactDao) {
		this.incidentImpactDao = incidentImpactDao;
	}
	
	/** 
	 * /**
	 *  * @param incidentPriorityDao the incidentPriorityDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentPriorityDao(IncidentPriorityDao incidentPriorityDao) {
		this.incidentPriorityDao = incidentPriorityDao;
	}

	/** 
	 * /**
	 *  * @param incidentSourceDao the incidentSourceDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentSourceDao(IncidentSourceDao incidentSourceDao) {
		this.incidentSourceDao = incidentSourceDao;
	}

	/** 
	 * /**
	 *  * @param incidentStatusDao the incidentStatusDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentStatusDao(IncidentStatusDao incidentStatusDao) {
		this.incidentStatusDao = incidentStatusDao;
	}

	/** 
	 * /**
	 *  * @param incidentUrgencyDao the incidentUrgencyDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentUrgencyDao(IncidentUrgencyDao incidentUrgencyDao) {
		this.incidentUrgencyDao = incidentUrgencyDao;
	}

	public void setSupportGroupDao(SupportGroupDao supportGroupDao) {
		this.supportGroupDao = supportGroupDao;
	}

    @Override
        public void accept(Incident incident) {
                incident.setSupportGroupMember(employeeService.getCurrentUser());
                this.eventDao.save(incident);
        }

    @Override
        public IncidentSearchCriteria getCurrentUserAssignedIncidentsSearchCriteria() {
                IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setSupportGroupMember(employeeService.getCurrentUser());

		return searchCriteria;
        }
}