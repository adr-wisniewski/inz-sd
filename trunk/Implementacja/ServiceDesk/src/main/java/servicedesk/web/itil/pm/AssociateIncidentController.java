/**
 * 
 */
package servicedesk.web.itil.pm;

import servicedesk.core.itil.pm.service.ProblemService;
import servicedesk.core.itil.im.service.IncidentService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import servicedesk.core.itil.im.app.IncidentSearchCriteria;
import servicedesk.core.itil.pm.domain.Problem;
import servicedesk.web.base.util.CheckboxSelection;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes({"problemId", "searchCriteria", "selection"})
public class AssociateIncidentController {
	Logger logger = Logger.getLogger(AssociateIncidentController.class);
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
	private IncidentService incidentService;

	/** 
	 * /**
	 *  * @param incidentService the incidentService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIncidentService(IncidentService incidentService) {
		// begin-user-code
		this.incidentService = incidentService;
		// end-user-code
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "pm/associate";
	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla wyszukiwania 
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SEARCH_ACTION_NAME = "/pm/search_incidents";
	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla dodania incydentow
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String ASSOCIATE_ACTION_NAME = "/pm/associate";
	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa akcji dla sukcesu
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SUCCESS_NAME = "/pm/associatesuccess";

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
	 * @param problemId
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SEARCH_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("id") Integer problemId) {
		model.addAttribute("problemId", problemId);
		model.addAttribute("problem", problemService.getById(problemId));
		model.addAttribute("searchCriteria", new IncidentSearchCriteria());
		model.addAttribute("incidents", null);
		model.addAttribute("selection", new CheckboxSelection());
		
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
	public String onSearch(ModelMap model, @ModelAttribute("searchCriteria") IncidentSearchCriteria searchCriteria) {
		model.addAttribute("incidents", incidentService.search(searchCriteria));
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @param selection
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = ASSOCIATE_ACTION_NAME, method = RequestMethod.POST)
	public String onAssociate(@ModelAttribute("problemId") Integer problemId, @ModelAttribute("selection") CheckboxSelection selection) {
		logger.info("onAssociate()");
		logger.info("selection: " + selection.getSelected());
		
		Problem problem = problemService.getById(problemId);
		problemService.associate(problem, selection.getSelected());
		return "redirect:" + SUCCESS_NAME +  "?id=" + problemId;
	}
}