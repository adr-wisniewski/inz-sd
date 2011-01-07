/**
 * 
 */
package sd.im.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sd.im.app.IncidentSearchCriteria;
import sd.im.domain.Incident;
import sd.im.domain.IncidentCategory;
import sd.im.domain.IncidentImpact;
import sd.im.domain.IncidentPriority;
import sd.im.domain.IncidentSource;
import sd.im.domain.IncidentStatus;
import sd.im.domain.IncidentUrgency;
import sd.im.domain.SupportGroup;
import sd.im.service.IncidentService;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"incidentSearchCriteria"} )
public class SearchIncidentController {
	Logger logger = Logger.getLogger(SearchIncidentController.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private IncidentService incidentService;

	/** 
	 * /**
	 *  * @param incidentService the incidentService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "im/search";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji do wyszukiwania
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SEARCH_ACTION_NAME = "/im/search";
	
	/**
	 * Nazwa akcji do przejrzenia otwartych incydentow aktualnie zalogowanego pracownika
	 */
	protected static final String MY_OPEN_ACTION_NAME = "/im/myOpen";
	
	/**
	 * Nazwa akcji do przejrzenia zamknietych incydentow aktualnie zalogowanego pracownika
	 */
	protected static final String MY_CLOSED_ACTION_NAME = "/im/myClosed";
	
	/**
	 * Nazwa akcji do wyswietlenia nie przypisanych incydentow
	 */
	protected static final String NOT_ASSIGNED_ACTION_NAME = "/im/notAssigned";


        /**
	 * Nazwa akcji do wyswietlenia nie przypisanych incydentow
	 */
	protected static final String MY_ASSIGNED_ACTION_NAME = "/im/myAssigned";

	@Autowired
	private PropertyEditorRegistrar propertyEditorRegistrar;
	
	public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
		this.propertyEditorRegistrar = propertyEditorRegistrar;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		propertyEditorRegistrar.registerCustomEditors(binder);
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param model
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SEARCH_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.addAttribute("incidents", null);
		model.addAttribute("incidentSearchCriteria", new IncidentSearchCriteria());
		
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param model
	 * @param searchCriteria
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SEARCH_ACTION_NAME, method = RequestMethod.POST)
	public String onSubmit(ModelMap model, @ModelAttribute("incidentSearchCriteria") IncidentSearchCriteria searchCriteria) {
		List<Incident> result = incidentService.search(searchCriteria);
		model.addAttribute("incidents", result);
		return VIEW_NAME;
	}
	
	@RequestMapping(value = MY_OPEN_ACTION_NAME, method = RequestMethod.GET)
	public String openIncidents(ModelMap model) {
		IncidentSearchCriteria searchCriteria = incidentService.getCurrentUserOpenIncidentsSearchCriteria();
		model.addAttribute("incidentSearchCriteria", searchCriteria);
		
		return onSubmit(model, searchCriteria);
	}
	
	@RequestMapping(value = MY_CLOSED_ACTION_NAME, method = RequestMethod.GET)
	public String closedIncidents(ModelMap model) {
		IncidentSearchCriteria searchCriteria = incidentService.getCurrentUserClosedIncidentsSearchCriteria();
		model.addAttribute("incidentSearchCriteria", searchCriteria);
		
		return onSubmit(model, searchCriteria);
	}
	
	@RequestMapping(value = NOT_ASSIGNED_ACTION_NAME, method = RequestMethod.GET)
	public String notAssigned(ModelMap model) {
		IncidentSearchCriteria searchCriteria = new IncidentSearchCriteria();
		searchCriteria.setNotAssigned(true);
		model.addAttribute("incidentSearchCriteria", searchCriteria);
		
		return onSubmit(model, searchCriteria);
	}

        @RequestMapping(value = MY_ASSIGNED_ACTION_NAME, method = RequestMethod.GET)
	public String myAssignedIncidents(ModelMap model) {
		IncidentSearchCriteria searchCriteria = incidentService.getCurrentUserAssignedIncidentsSearchCriteria();
		model.addAttribute("incidentSearchCriteria", searchCriteria);

		return onSubmit(model, searchCriteria);
	}

	@ModelAttribute("priorities")
	public List<IncidentPriority> populatePriorities() {
		return incidentService.getAllPriorities();
	}

	@ModelAttribute("statuses")
	public List<IncidentStatus> populateStatuses() {
		return incidentService.getAllStatuses();
	}
	
	@ModelAttribute("impacts")
	public List<IncidentImpact> populateImpacts() {
		return incidentService.getAllImpacts();
	}
	
	@ModelAttribute("urgencies")
	public List<IncidentUrgency> populateUrgencies() {
		return incidentService.getAllUrgencies();
	}
	
	@ModelAttribute("categories")
	public List<IncidentCategory> populateCategories() {
		return incidentService.getAllCategories();
	}

	@ModelAttribute("sources")
	public List<IncidentSource> populateSources() {
		return incidentService.getAllSources();
	}
	
	@ModelAttribute("groups")
	public List<SupportGroup> populateGroups() {
		return incidentService.getAllGroups();
	}
}