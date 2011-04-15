/**
 * 
 */
package servicedesk.pm.web;

import java.util.List;

import org.apache.log4j.Logger;
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

import servicedesk.domain.Comment;
import servicedesk.im.domain.SupportGroup;
import servicedesk.pm.domain.Problem;
import servicedesk.pm.domain.ProblemCategory;
import servicedesk.pm.domain.ProblemImpact;
import servicedesk.pm.domain.ProblemPriority;
import servicedesk.pm.domain.ProblemStatus;
import servicedesk.pm.domain.ProblemUrgency;
import servicedesk.pm.service.ProblemService;
import servicedesk.pm.validator.EditProblemValidator;
import servicedesk.util.FormUtils;
import servicedesk.validator.CommentValidator;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"problem", "comment"} )
public class EditProblemController {
	Logger logger = Logger.getLogger(EditProblemController.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private ProblemService problemService;

	/** 
	 * /**
	 *  * @param problemService the problemService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setProblemService(ProblemService problemService) {
		// begin-user-code
		this.problemService = problemService;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private EditProblemValidator editProblemValidator;

	/** 
	 * /**
	 *  * @param editProblemValidator the editProblemValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEditProblemValidator(EditProblemValidator editProblemValidator) {
		// begin-user-code
		this.editProblemValidator = editProblemValidator;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
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
		// begin-user-code
		this.commentValidator = commentValidator;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "pm/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;do&nbsp;edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_ACTION_NAME = "/pm/edit";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;dla&nbsp;sukcesu&nbsp;edycji
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String EDIT_SUCCESS_ACTION_NAME = "/pm/editsuccess";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;dokonujacej&nbsp;dodania&nbsp;komentarza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String COMMENT_ACTION_NAME = "/pm/addcomment";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;dla&nbsp;przypadku,&nbsp;gdy&nbsp;pomyslanie&nbsp;dodano&nbsp;komentarz
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String COMMENT_SUCCESS_NAME = "/pm/commentsuccess";
	/**
	 * 
	 */
	protected static final String SOLUTION_SUCCESS = "/pm/solutionsuccess";
	/**
	 * 
	 */
	protected static final String DELETE_INCIDENT_ACTION_NAME = "/pm/delete_incident";
	/**
	 * 
	 */
	protected static final String DELETE_INCIDENT_SUCCESS = "/pm/delete_incident_success";
	
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
	 * @param ModelMapmap
	 * @param id
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("id") Integer id) {
		Problem problem = problemService.getById(id);		
		Comment comment = new Comment();
		model.addAttribute("problem", problem);
		model.addAttribute("comment", comment);
		model.addAttribute("comments", problem.getComments());
		
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @param result
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.POST)
	public String onEdit(@ModelAttribute("problem") Problem problem, BindingResult result) {
		editProblemValidator.validate(problem, result);
		if(result.hasErrors()) {
			return  VIEW_NAME;
		}
		else {
			problemService.edit(problem);
			return "redirect:" + EDIT_SUCCESS_ACTION_NAME + "?id=" + problem.getId();
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param model
	 * @param id
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = EDIT_SUCCESS_ACTION_NAME)
	public String onEditSuccess(ModelMap model, @RequestParam("id") Integer id) {
		return onSuccess(model, id, "editsuccess");
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param model
	 * @param id
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = AddProblemController.ADD_SUCCESS_ACTION_NAME)
	public String onAddSuccess(ModelMap model, @RequestParam("id") Integer id) {
		return onSuccess(model, id, "addsuccess");
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SOLUTION_SUCCESS)
	public String onSolutionSuccess(ModelMap model, @RequestParam("id") Integer id) {
		return onSuccess(model, id, "solutionsuccess");
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = AssociateIncidentController.SUCCESS_NAME)
	public String onAssociateSuccess(ModelMap model, @RequestParam("id") Integer id) {
		return onSuccess(model, id, "associatesuccess");
	}

	private String onSuccess(ModelMap model, Integer id, String message) {
		FormUtils.setSuccessMessage(message, model);
		return showForm(model, id);
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
	public String onAddComment(@ModelAttribute("problem") Problem problem, @ModelAttribute("comment") Comment comment, BindingResult result) {
		commentValidator.validate(comment, result);
		if(result.hasErrors()) {
			return VIEW_NAME;
		}
		else {
			problemService.addComment(problem, comment);
			return "redirect:" + COMMENT_SUCCESS_NAME + "?id=" + problem.getId();
		}
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
	public String onCommentSuccess(ModelMap model, @RequestParam("id") Integer problemId) {
		return onSuccess(model, problemId, "commentsuccess");
	}
	
	@RequestMapping(value = DELETE_INCIDENT_ACTION_NAME, method = RequestMethod.GET)
	public String onDeleteIncident(@ModelAttribute("problem") Problem problem, @RequestParam("incidentId") Integer incidentId) {
		problemService.deleteIncident(problem, incidentId);
		return "redirect:" + DELETE_INCIDENT_SUCCESS + "?id=" + problem.getId();
	}
	
	@RequestMapping(value = DELETE_INCIDENT_SUCCESS, method = RequestMethod.GET)
	public String onDeleteIncidentSuccess(ModelMap model, @RequestParam("id") Integer problemId) {
		return onSuccess(model, problemId, "delete_incident_success");
	}
	
	@ModelAttribute("categories")
	public List<ProblemCategory> populateCategories() {
		return problemService.getAllCategories();
	}
	
	@ModelAttribute("priorities")
	public List<ProblemPriority> populatePriorities() {
		return problemService.getAllPriorities();
	}
	
	@ModelAttribute("statuses")
	public List<ProblemStatus> populateStatuses() {
		return problemService.getAllStatuses();
	}
	
	@ModelAttribute("urgencies")
	public List<ProblemUrgency> populateUrgencies() {
		return problemService.getAllUrgencies();
	}
	
	@ModelAttribute("impacts")
	public List<ProblemImpact> populateImpacts() {
		return problemService.getAllImpacts();
	}
	
	@ModelAttribute("groups")
	public List<SupportGroup> populateGroups() {
		return problemService.getAllGroups();
	}
}