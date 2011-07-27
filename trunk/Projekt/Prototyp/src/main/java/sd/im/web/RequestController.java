/**
 * 
 */
package sd.im.web;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sd.im.app.Request;
import sd.im.app.RequestSearchCriteria;
import sd.im.app.RequestService;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 */
@Controller
@RequestMapping("/im2/*")
public class RequestController {
	private static Logger logger = Logger.getLogger(RequestController.class);
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Autowired
	private RequestService requestService;

	/** 
	 * /**
	 *  * @return the requestService
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RequestService getRequestService() {
		// begin-user-code
		return requestService;
		// end-user-code
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
	 * @param searchCriteria
	 */
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ModelAndView searchGET(RequestSearchCriteria searchCriteria) {
		ModelMap model = new ModelMap();
		model.addAttribute("requests", null);
		return new ModelAndView("im/search", model);
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView searchPOST(RequestSearchCriteria searchCriteria) {
		Set<Request> result = requestService.search(searchCriteria);
		ModelMap model = new ModelMap();
		model.addAttribute("requests", result);
		return new ModelAndView("im/search", model);
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@RequestMapping(value = "addform")
	public String addForm(Request request) {
		return "im/add";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Request request) {
		requestService.addRequest(request);
		logger.debug("add: " + request);
		return "im/add";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void editResolution() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addComment() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void attachFile() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}