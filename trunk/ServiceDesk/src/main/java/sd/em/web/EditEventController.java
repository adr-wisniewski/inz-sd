/**
 * 
 */
package sd.em.web;


import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sd.em.domain.Event;
import sd.em.service.EventService;
import sd.im.domain.Incident;
import sd.util.FormUtils;

/** 
 * <!-- begin-UML-doc -->
 * Klasa zarzadzajace edycja incydentow.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"event"} )
public class EditEventController {
	/** 
	 * <!-- begin-UML-doc -->
	 * Usluga incydentow
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
	 * Nazwa widoku formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "em/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji do edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_ACTION_NAME = "/em/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla sukcesu edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_SUCCESS_ACTION_NAME = "/em/editsuccess";

	
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
	 * Wyswietla formularz do edycji incydentu
	 * <!-- end-UML-doc -->
	 * @param model Model
	 * @param incidentId Id&nbsp;incydentu
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("id") Integer eventId) {
		Event event = eventService.get(eventId);
		model.addAttribute("event", event);
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param incident Incydent do uaktualnienia
	 * @param result
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.POST)
	public String onEdit(@ModelAttribute("incident") Incident incident, BindingResult result) {
		/*
		editIncidentValidator.validate(incident, result);
		if(result.hasErrors()) {
			return  VIEW_NAME;
		}
		else {
			incidentService.edit(incident);
			return "redirect:" + EDIT_SUCCESS_ACTION_NAME + "?id=" + incident.getId();
		}
		*/
		//TODO
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Akcja wykonywana, gdy pomyslnie uda sie uaktualnic incydent
	 * <!-- end-UML-doc -->
	 * @param model Model
	 * @param incidentId Id&nbsp;incydentu
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_SUCCESS_ACTION_NAME)
	public String onEditSuccess(ModelMap model, @RequestParam("id") Integer incidentId) {
		return onSuccess(model, incidentId, "editsuccess");
	}

	private String onSuccess(ModelMap model, Integer incidentId, String message) {
		FormUtils.setSuccessMessage(message, model);
		return showForm(model, incidentId);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Akcja wykonywana, gdy pomyslnie doda sie nowy incydent.
	 * <!-- end-UML-doc -->
	 * @param model Model
	 * @param incidentId Id nowego incydentu.
	 * @return Nazwa widoku formularza
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	/*
	@ModelAttribute("significance_types")
	public List<IncidentSource> populateSignificanceTypes() {
		return eventService.getAllSignificanceTypes();
	}
	*/
}