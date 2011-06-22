package sd.im.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import sd.im.app.Request;
import sd.im.app.RequestService;
import sd.im.validator.AddRequestValidator;

@Controller
@RequestMapping("/im/adddd")
@SessionAttributes("request")
public class AddRequestController  {
	//private static Logger logger = Logger.getLogger(AddRequestController.class);
	@Autowired
	private AddRequestValidator addRequestValidator;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Autowired
	private RequestService requestService;

	public void setAddRequestValidator(AddRequestValidator addRequestValidator) {
		this.addRequestValidator = addRequestValidator;
	}


	/** 
	 * /**
	 *  * @param requestService the requestService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRequestService(RequestService requestService) {
		// begin-user-code
		this.requestService = requestService;
		// end-user-code
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		Request request = new Request();
		model.addAttribute("request", request);
		return "im/add";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("request") Request request, BindingResult result) {
		addRequestValidator.validate(request, result);
		if(result.hasErrors()) {
			return "im/add";
		}
		else {
			requestService.addRequest(request);
			return "redirect:search";
		}		
	}
}
