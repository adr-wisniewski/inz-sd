/**
 * 
 */
package servicedesk.pm.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.event.service.GenericEventService;
import servicedesk.im.dao.SupportGroupDao;
import servicedesk.im.domain.Incident;
import servicedesk.im.domain.SupportGroup;
import servicedesk.im.service.IncidentService;
import servicedesk.pm.app.KnownErrorSearchCriteria;
import servicedesk.pm.app.ProblemSearchCriteria;
import servicedesk.pm.dao.KnownErrorDao;
import servicedesk.pm.dao.ProblemCategoryDao;
import servicedesk.pm.dao.ProblemDao;
import servicedesk.pm.dao.ProblemImpactDao;
import servicedesk.pm.dao.ProblemPriorityDao;
import servicedesk.pm.dao.ProblemStatusDao;
import servicedesk.pm.dao.ProblemUrgencyDao;
import servicedesk.pm.domain.KnownError;
import servicedesk.pm.domain.Problem;
import servicedesk.pm.domain.ProblemCategory;
import servicedesk.pm.domain.ProblemImpact;
import servicedesk.pm.domain.ProblemPriority;
import servicedesk.pm.domain.ProblemStatus;
import servicedesk.pm.domain.ProblemUrgency;
import servicedesk.pm.domain.Solution;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Service
@Transactional
public class ProblemServiceImpl extends GenericEventService<Problem, ProblemDao, ProblemSearchCriteria> implements ProblemService {
	private Logger logger = Logger.getLogger(ProblemServiceImpl.class);
	
	@Autowired
	public void setProblemDao(ProblemDao problemDao) {
		this.eventDao = problemDao;
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemCategoryDao problemCategoryDao;

	/** 
	 * /**
	 *  * @param problemCategoryDao the problemCategoryDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemCategoryDao(ProblemCategoryDao problemCategoryDao) {
		// begin-user-code
		this.problemCategoryDao = problemCategoryDao;
		// end-user-code
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemImpactDao problemImpactDao;

	/** 
	 * /**
	 *  * @param problemImpactDao the problemImpactDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemImpactDao(ProblemImpactDao problemImpactDao) {
		// begin-user-code
		this.problemImpactDao = problemImpactDao;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemPriorityDao problemPriorityDao;

	/** 
	 * /**
	 *  * @param problemPriorityDao the problemPriorityDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemPriorityDao(ProblemPriorityDao problemPriorityDao) {
		// begin-user-code
		this.problemPriorityDao = problemPriorityDao;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemUrgencyDao problemUrgencyDao;

	/** 
	 * /**
	 *  * @param problemUrgencyDao the problemUrgencyDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemUrgencyDao(ProblemUrgencyDao problemUrgencyDao) {
		// begin-user-code
		this.problemUrgencyDao = problemUrgencyDao;
		// end-user-code
	}
	
	@Autowired
	private SupportGroupDao supportGroupDao;
	
	public void setSupportGroupDao(SupportGroupDao supportGroupDao) {
		this.supportGroupDao = supportGroupDao;
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemStatusDao problemStatusDao;
	
	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private KnownErrorDao knownErrorDao;
	
	public void setKnownErrorDao(KnownErrorDao knownErrorDao) {
		this.knownErrorDao = knownErrorDao;
	}

	/** 
	 * /**
	 *  * @param problemStatusDao the problemStatusDao to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemStatusDao(ProblemStatusDao problemStatusDao) {
		// begin-user-code
		this.problemStatusDao = problemStatusDao;
		// end-user-code
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#getAllCategories()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<ProblemCategory> getAllCategories() {
		return problemCategoryDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#getAllStatuses()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<ProblemStatus> getAllStatuses() {
		return problemStatusDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#getAllUrgencies()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<ProblemUrgency> getAllUrgencies() {
		return problemUrgencyDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#getAllImpacts()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<ProblemImpact> getAllImpacts() {
		return problemImpactDao.getAll();
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#getAllPriorities()
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public List<ProblemPriority> getAllPriorities() {
		return problemPriorityDao.getAll();
	}
	
    @Override
	public List<SupportGroup> getAllGroups() {
		return supportGroupDao.getAll();
	}
	
	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#addSolution(Problem problem, Solution solution)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public void addSolution(Problem problem, Solution solution) {
		problem.addSolution(solution);
		solution.setCreationDate(new Date());
		solution.setAuthor(employeeService.getCurrentUser());
logger.info(solution.toString());
		eventDao.save(problem);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see ProblemService#associate(Problem problem, String... incidentIds)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @Override
	public void associate(Problem problem, Set<String> incidentIds) {
		//Set<Incident> incidents = new HashSet<Incident>();
		for(String s : incidentIds) {
			Integer incidentId = Integer.valueOf(s);
			Incident incident = incidentService.getById(incidentId);
			//incidents.add(incident);
			problem.addIncident(incident);
		}
		
		//problem.setIncidents(incidents);
		eventDao.save(problem);
	}

	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
		
	}

    @Override
	public void deleteIncident(Problem problem, Integer incidentId) {
		problem.removeIncident(incidentService.getById(incidentId));
		eventDao.save(problem);
	}
	
    @Override
	public void add(Problem problem) {
		problem.setStatus(ProblemStatus.OPEN);
		
		super.add(problem);
	}
	
    @Override
	public void edit(Problem problem) {
		if(problem.getStatus().equals(ProblemStatus.CLOSED)) {
			problem.setClosureDate(new Date());
		}
		
		super.edit(problem);
	}

    @Override
	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria) {
		return knownErrorDao.search(searchCriteria);
	}
}