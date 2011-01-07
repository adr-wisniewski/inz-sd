/**
 * 
 */
package sd.im.service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.domain.HistoryAction;
import sd.domain.HistoryActionType;
import sd.domain.HistoryActions;
import sd.domain.HistoryBuilder;
import sd.event.service.GenericEventService;
import sd.im.app.IncidentSearchCriteria;
import sd.im.dao.IncidentCategoryDao;
import sd.im.dao.IncidentDao;
import sd.im.dao.IncidentHistoryDao;
import sd.im.dao.IncidentImpactDao;
import sd.im.dao.IncidentPriorityDao;
import sd.im.dao.IncidentSourceDao;
import sd.im.dao.IncidentStatusDao;
import sd.im.dao.IncidentUrgencyDao;
import sd.im.dao.SupportGroupDao;
import sd.im.domain.Incident;
import sd.im.domain.IncidentCategory;
import sd.im.domain.IncidentHistory;
import sd.im.domain.IncidentImpact;
import sd.im.domain.IncidentPriority;
import sd.im.domain.IncidentSource;
import sd.im.domain.IncidentStatus;
import sd.im.domain.IncidentUrgency;
import sd.im.domain.SupportGroup;

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
		
		HistoryBuilder hb = new HistoryBuilder(actions);
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
	public List<IncidentCategory> getAllCategories() {
		return incidentCategoryDao.fetchAll();
	}

	public List<SupportGroup> getAllGroups() {
		return supportGroupDao.fetchAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllImpacts()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentImpact> getAllImpacts() {
		return incidentImpactDao.fetchAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllPriorities()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentPriority> getAllPriorities() {
		return incidentPriorityDao.fetchAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllSources()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentSource> getAllSources() {
		return incidentSourceDao.fetchAll();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllStatuses()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentStatus> getAllStatuses() {
		return incidentStatusDao.fetchAll();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see IncidentService#getAllUrgencies()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentUrgency> getAllUrgencies() {
		return incidentUrgencyDao.fetchAll();
	}

	public IncidentSearchCriteria getCurrentUserClosedIncidentsSearchCriteria() {
		IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setAuthor(employeeService.getCurrentUser());
		searchCriteria.setStatus(IncidentStatus.CLOSED);
		
		return searchCriteria;
	}

	/**
	 * (non-Javadoc)
	 * @see sd.im.service.IncidentService#getCurrentUserOpenIncidentsSearchCriteria()
	 */
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

	public SupportGroup getGroupById(Integer groupId) {
		return supportGroupDao.findById(groupId);
	}
	
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

        public void accept(Incident incident) {
                incident.setSupportGroupMember(employeeService.getCurrentUser());
                this.eventDao.save(incident);
        }

        public IncidentSearchCriteria getCurrentUserAssignedIncidentsSearchCriteria() {
                IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setSupportGroupMember(employeeService.getCurrentUser());

		return searchCriteria;
        }
}