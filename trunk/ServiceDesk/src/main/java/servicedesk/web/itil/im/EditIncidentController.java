/**
 * 
 */
package servicedesk.web.itil.im;


import java.util.List;

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

import servicedesk.core.base.comment.domain.Comment;
import servicedesk.core.itil.im.domain.Incident;
import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.core.itil.im.domain.IncidentImpact;
import servicedesk.core.itil.im.domain.IncidentPriority;
import servicedesk.core.itil.im.domain.IncidentSource;
import servicedesk.core.itil.im.domain.IncidentStatus;
import servicedesk.core.itil.im.domain.IncidentUrgency;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.im.service.IncidentService;
import servicedesk.core.itil.im.validator.EditIncidentValidator;
import servicedesk.web.base.util.FormUtils;
import servicedesk.core.base.comment.validator.CommentValidator;

/** 
 * <!-- begin-UML-doc -->
 * Klasa zarzadzajace edycja incydentow.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"incident", "comment"} )
public class EditIncidentController {
	/** 
	 * <!-- begin-UML-doc -->
	 * Usluga incydentow
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
	 * Walidator dla incydentow
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private EditIncidentValidator editIncidentValidator;

	/** 
	 * /**
	 *  * @param editIncidentValidator the editIncidentValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEditIncidentValidator(EditIncidentValidator editIncidentValidator) {
		this.editIncidentValidator = editIncidentValidator;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Walidator dla komentarzy
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private CommentValidator commentValidator;
	
	/** 
	 * /**
	 *  * @param commentValidator the commentValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCommentValidator(CommentValidator commentValidator) {
		this.commentValidator = commentValidator;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa widoku formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "im/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji do edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_ACTION_NAME = "/im/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla sukcesu edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_SUCCESS_ACTION_NAME = "/im/editsuccess";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dokonujacej dodania komentarza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String COMMENT_ACTION_NAME = "/im/addcomment";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla przypadku, gdy pomyslanie dodano komentarz
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String COMMENT_SUCCESS_NAME = "/im/commentsuccess";

        /**
	 * Nazwa akcji dokonujacej przypisania incydentu
	 */
	protected static final String ACCEPT_ACTION_NAME = "/im/accept";

	/**
	 * Nazwa akcji dla przypadku, gdy pomyslanie przypisano incydent
	 */
	protected static final String ACCEPT_SUCCESS_NAME = "/im/acceptsuccess";

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
	public String showForm(ModelMap model, @RequestParam("id") Integer incidentId) {
		Incident incident = incidentService.getById(incidentId);
		Comment comment = new Comment();
		model.addAttribute("incident", incident);
		model.addAttribute("comment", comment);
		model.addAttribute("comments", incident.getComments());
		model.addAttribute("history", incidentService.getHistory(incident));
		
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
		editIncidentValidator.validate(incident, result);
		if(result.hasErrors()) {
			return  VIEW_NAME;
		}
		else {
			incidentService.edit(incident);
			return "redirect:" + EDIT_SUCCESS_ACTION_NAME + "?id=" + incident.getId();
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Akcja wykonywana przy dodaniu nowego komentarz
	 * <!-- end-UML-doc -->
	 * @param incident Incydent, ktoremu dodawany jest komentarz
	 * @param comment Nowy komentarz
	 * @param result
	 * @return Nazwa widoku
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = COMMENT_ACTION_NAME, method = RequestMethod.POST)
	public String onAddComment(@ModelAttribute("incident") Incident incident, @ModelAttribute("comment") Comment comment, BindingResult result) {
		commentValidator.validate(comment, result);
		if(result.hasErrors()) {
			return VIEW_NAME;
		}
		else {
			incidentService.addComment(incident, comment);
			return "redirect:" + COMMENT_SUCCESS_NAME + "?id=" + incident.getId();
		}
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
	@RequestMapping(value = AddIncidentController.ADD_SUCCESS_ACTION_NAME)
	public String onAddSuccess(ModelMap model, @RequestParam("id") Integer incidentId) {
		FormUtils.setSuccessMessage("addsuccess", model);
		return showForm(model, incidentId);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Akcja&nbsp;wykonywana,&nbsp;gdy&nbsp;pomyslnie uda sie dodac komentarz.
	 * <!-- end-UML-doc -->
	 * @param model Model
	 * @param incidentId Id&nbsp;incydentu
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = COMMENT_SUCCESS_NAME, method = RequestMethod.GET)
	public String onCommentSuccess(ModelMap model, @RequestParam("id") Integer incidentId) {
		FormUtils.setSuccessMessage("commentsuccess", model);
		return showForm(model, incidentId);
	}

	@RequestMapping(value = ACCEPT_ACTION_NAME, method = RequestMethod.GET)
	public String onAccept(@RequestParam("id") Integer id) {
            Incident incident = incidentService.getById(id);
            incidentService.accept(incident);
            return "redirect:" + ACCEPT_SUCCESS_NAME + "?id=" + incident.getId();
	}

	@RequestMapping(value = ACCEPT_SUCCESS_NAME, method = RequestMethod.GET)
	public String onAcceptSuccess(ModelMap model, @RequestParam("id") Integer incidentId) {
		FormUtils.setSuccessMessage("acceptsuccess", model);
		return showForm(model, incidentId);
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