/**
 * 
 */
package servicedesk.web.itil.pm;

import servicedesk.core.itil.im.service.IncidentService;
import servicedesk.core.itil.pm.service.ProblemService;
import servicedesk.core.itil.pm.validator.AddProblemValidator;
import servicedesk.core.itil.pm.domain.Problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes({"problem"})
public class AddProblemController {
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
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private AddProblemValidator addProblemValidator;


	/** 
	 * /**
	 *  * @param addProblemValidator the addProblemValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setAddProblemValidator(AddProblemValidator addProblemValidator) {
		this.addProblemValidator = addProblemValidator;
	}
	
	@Autowired
	private IncidentService incidentService;
	
	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "pm/add";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;do&nbsp;dodania problemu
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String ADD_ACTION_NAME = "/pm/add";

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String ADD_SUCCESS_ACTION_NAME = "/pm/addsuccess";

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param ModelMapmap
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = ADD_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap map) {
		Problem problem = new Problem();
		map.addAttribute("problem", problem);
		return VIEW_NAME;
	}

	@RequestMapping(value = "/pm/addFromIncident", method = RequestMethod.GET)
	public String addProblemFromIncident(ModelMap map, @RequestParam("incidentId") Integer incidentId) {
		Problem problem = new Problem();
		problem.addIncident(incidentService.getById(incidentId));
		map.addAttribute("problem", problem);
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
	@RequestMapping(value = ADD_ACTION_NAME, method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("problem") Problem problem, BindingResult result) {
		addProblemValidator.validate(problem, result);
		if(result.hasErrors()) {
			return VIEW_NAME;
		}
		else {		
			problemService.add(problem);
			return "redirect:" + ADD_SUCCESS_ACTION_NAME + "?id=" + problem.getId();
		}
	}
}