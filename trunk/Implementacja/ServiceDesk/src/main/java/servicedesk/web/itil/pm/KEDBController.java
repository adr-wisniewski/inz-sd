package servicedesk.web.itil.pm;

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

import servicedesk.core.itil.pm.app.KnownErrorSearchCriteria;
import servicedesk.core.itil.pm.domain.KnownError;
import servicedesk.core.itil.pm.service.ProblemService;

@Controller
@SessionAttributes( {"searchCriteria"} )
public class KEDBController {
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
	protected static final String VIEW_NAME = "pm/kedb";

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;do&nbsp;wyszukiwania
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String SEARCH_ACTION_NAME = "/pm/kedb";
	
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
		model.addAttribute("known_errors", null);
		KnownErrorSearchCriteria searchCriteria = new KnownErrorSearchCriteria();
		model.addAttribute("searchCriteria", searchCriteria);
		
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
	public String onSubmit(ModelMap model, @ModelAttribute("searchCriteria") KnownErrorSearchCriteria searchCriteria) {
		List<KnownError> result = problemService.search(searchCriteria);
		model.addAttribute("known_errors", result);
		
		return VIEW_NAME;
	}
}
