/**
 * 
 */
package servicedesk.web.itil.im;

import java.util.List;

import servicedesk.core.itil.im.service.IncidentService;
import servicedesk.core.itil.im.validator.AddIncidentValidator;
import servicedesk.core.itil.im.domain.Incident;
import servicedesk.core.itil.im.domain.IncidentSource;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Controller
@SessionAttributes("incident")
public class AddIncidentController {
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
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Autowired
	private AddIncidentValidator addIncidentValidator;


	/** 
	 * /**
	 *  * @param addIncidentValidator the addIncidentValidator to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setAddIncidentValidator(AddIncidentValidator addIncidentValidator) {
		this.addIncidentValidator = addIncidentValidator;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;widoku&nbsp;formularza
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String VIEW_NAME = "im/add";


	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;do&nbsp;dodania incydentu
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String ADD_ACTION_NAME = "/im/add";



	/** 
	 * <!-- begin-UML-doc -->
	 * Nazwa&nbsp;akcji&nbsp;dla&nbsp;przypadku,&nbsp;gdy&nbsp;pomyslanie&nbsp;dodano&nbsp;incydent
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected static final String ADD_SUCCESS_ACTION_NAME = "/im/addsuccess";

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
	 * @param ModelMap map
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = ADD_ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap map) {
		Incident incident = new Incident();
		map.addAttribute("incident", incident);
		return VIEW_NAME;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param incident
	 * @param result
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = ADD_ACTION_NAME, method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("incident") Incident incident, BindingResult result) {
		addIncidentValidator.validate(incident, result);
		if(result.hasErrors()) {
			return VIEW_NAME;
		}
		else {
			incidentService.add(incident);
			return "redirect:" + ADD_SUCCESS_ACTION_NAME + "?id=" + incident.getId();
		}
	}
	
	@ModelAttribute("sources")
	List<IncidentSource> populateSources() {
		List<IncidentSource> result = incidentService.getAllSources();
		result.remove(IncidentSource.EVENT);
		result.remove(IncidentSource.WEB_FORM);
		return result;
	}
}