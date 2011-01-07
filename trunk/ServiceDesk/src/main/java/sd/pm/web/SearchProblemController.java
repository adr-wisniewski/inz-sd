/**
 * 
 */
package sd.pm.web;

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

import sd.im.domain.SupportGroup;
import sd.pm.app.ProblemSearchCriteria;
import sd.pm.domain.Problem;
import sd.pm.domain.ProblemCategory;
import sd.pm.domain.ProblemImpact;
import sd.pm.domain.ProblemPriority;
import sd.pm.domain.ProblemStatus;
import sd.pm.domain.ProblemUrgency;
import sd.pm.service.ProblemService;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"problemSearchCriteria"} )
public class SearchProblemController {
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
		this.problemService = problemService;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "pm/search";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;do&nbsp;wyszukiwania
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SEARCH_ACTION_NAME = "/pm/search";
	
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
		model.addAttribute("problems", null);
		model.addAttribute("problemSearchCriteria", new ProblemSearchCriteria());
		
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
	public String onSubmit(ModelMap model, @ModelAttribute("problemSearchCriteria") ProblemSearchCriteria searchCriteria) {
		List<Problem> result = problemService.search(searchCriteria);
		model.addAttribute("problems", result);
		
		return VIEW_NAME;
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