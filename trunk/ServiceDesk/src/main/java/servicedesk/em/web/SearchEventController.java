/**
 * 
 */
package servicedesk.em.web;

import java.util.List;

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

import servicedesk.em.app.EventSearchCriteria;
import servicedesk.em.domain.Event;
import servicedesk.em.domain.EventSignificance;
import servicedesk.em.service.EventService;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"eventSearchCriteria"} )
public class SearchEventController {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private EventService eventService;

	/** 
	 * /**
	 *  * @param incidentService the incidentService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "em/search";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji do wyszukiwania
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SEARCH_ACTION_NAME = "/em/search";
	
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
		model.addAttribute("events", null);
		model.addAttribute("eventSearchCriteria", new EventSearchCriteria());
		
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
	public String onSubmit(ModelMap model, @ModelAttribute("eventSearchCriteria") EventSearchCriteria searchCriteria) {
		List<Event> result = eventService.search(searchCriteria);
		model.addAttribute("events", result);
		return VIEW_NAME;
	}
	
	@ModelAttribute("significance_types")
	public List<EventSignificance> populateTypes() {
		return eventService.getAllSignificanceTypes();
	}
}