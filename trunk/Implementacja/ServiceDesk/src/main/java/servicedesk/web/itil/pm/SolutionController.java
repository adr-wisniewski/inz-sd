/**
 * 
 */
package servicedesk.web.itil.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import servicedesk.core.itil.pm.domain.Problem;
import servicedesk.core.itil.pm.domain.Solution;
import servicedesk.core.itil.pm.service.ProblemService;
import servicedesk.core.itil.pm.validator.SolutionValidator;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes( {"problemId", "solution"} )
public class SolutionController {
	protected static final String VIEW_NAME = "pm/solution";
	protected static final String SOLUTION_ACTION_NAME = "/pm/solution";
	
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
	private SolutionValidator solutionValidator;

	/** 
	 * /**
	 *  * @param solutionValidator the solutionValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setSolutionValidator(SolutionValidator solutionValidator) {
		// begin-user-code
		this.solutionValidator = solutionValidator;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param ModelMapmap
	 * @param id identyfikator problemu
	 * @param code kod typu rozwiazania
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SOLUTION_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("id") Integer problemId, @RequestParam("type") String type) {
		Problem problem = problemService.getById(problemId);		
		//model.addAttribute("problem", problem);
		model.addAttribute("problemId", problemId);
		Solution solution = problem.getSolutionByCode(type);
		if(solution == null) {
			solution = new Solution();
			solution.setType(type);
		}
		model.addAttribute("solution", solution);
		
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @param solution
	 * @param result
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = SOLUTION_ACTION_NAME, method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("problemId") Integer problemId, @ModelAttribute("solution") Solution solution, BindingResult result) {
		solutionValidator.validate(solution, result);
		if(result.hasErrors()) {
			return VIEW_NAME;
		}
		else {
			Problem problem = problemService.getById(problemId);
			problemService.addSolution(problem, solution);
			return "redirect:" + EditProblemController.SOLUTION_SUCCESS + "?id=" + problem.getId();
		}
	}
}