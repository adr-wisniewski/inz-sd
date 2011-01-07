package sd.im.web;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import sd.im.app.Comment;
import sd.im.app.Request;
import sd.im.app.RequestImpact;
import sd.im.app.RequestPriority;
import sd.im.app.RequestSearchCriteria;
import sd.im.app.RequestService;
import sd.im.app.RequestStatus;
import sd.im.app.TestIncidents;
import sd.im.validator.AddRequestValidator;
import sd.im.validator.CommentValidator;
import sd.im.validator.EditRequestValidator;

@Controller
@SessionAttributes( {"request", "comment", "requestSearchCriteria", "helper"} )
public class EditRequestController  {
	private static Logger logger = Logger.getLogger(EditRequestController.class);
	
	@Autowired
	private AddRequestValidator addRequestValidator;
	

	public void setAddRequestValidator(AddRequestValidator addRequestValidator) {
		this.addRequestValidator = addRequestValidator;
	}

	@Autowired
	private EditRequestValidator editRequestValidator;
	@Autowired
	private CommentValidator commentValidator;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Autowired
	private RequestService requestService;

	public void setEditRequestValidator(EditRequestValidator editRequestValidator) {
		this.editRequestValidator = editRequestValidator;
	}

	/** 
	 * /**
	 *  * @param requestService the requestService to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}
	
	
	
	public void setCommentValidator(CommentValidator commentValidator) {
		this.commentValidator = commentValidator;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@RequestMapping(value = "/im/edit", method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("id") Integer id) {
		Request request = requestService.getRequestById(id);
		Comment comment = new Comment();
		model.addAttribute("request", request);
		model.addAttribute("comment", comment);
		model.addAttribute("helper", new TestIncidents());
		model.addAttribute("comments", requestService.getRequestComments(request));
		return "im/edit";
	}

	@RequestMapping(value = "/im/editsuccess", method = RequestMethod.GET)
	public String editSuccess(ModelMap model, @RequestParam("id") Integer id) {
		logger.info("editSuccess(): ");
		
		setSuccessMessage(model, "Zapisano poprawnie.");
		
		return showForm(model, id);
	}
	
	@RequestMapping(value = "/im/edit", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("request") Request request, BindingResult result) {
		logger.info("onSubmit(): " + request.toString());
		
		editRequestValidator.validate(request, result);
		if(result.hasErrors()) {
			return  "im/edit" ;
		}
		else {
			requestService.editRequest(request);
			
			return "redirect:/im/editsuccess?id=" + request.getId();
		}		
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value = "/im/addcomment", method = RequestMethod.POST)
	public String addComment(@ModelAttribute("request") Request request, @ModelAttribute("comment") Comment comment, BindingResult result) {
		logger.info("addComment(): " + comment.toString());
		
		commentValidator.validate(comment, result);
		if(result.hasErrors()) {
			return "im/edit";
		}
		else {
			comment.setRequestId(request.getId());
			requestService.addComment(comment);
			return "redirect:/im/commentsuccess?id=" + request.getId();
		}
	}
	
	@RequestMapping(value = "/im/commentsuccess", method = RequestMethod.GET)
	public String commentSuccess(ModelMap model, @RequestParam("id") Integer id) {
		logger.info("commentSuccess(): ");
		
		setSuccessMessage(model, "Dodano komentarz.");
		
		return showForm(model, id);
	}
	
	
	@RequestMapping(value = "/im/addd", method = RequestMethod.GET)
	public String showAddForm(ModelMap model) {
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
	@RequestMapping(value = "/im/addd", method = RequestMethod.POST)
	public String onSubmitAdd(@ModelAttribute("request") Request request, BindingResult result) {
		addRequestValidator.validate(request, result);
		if(result.hasErrors()) {
			return "im/add";
		}
		else {
			requestService.addRequest(request);
			return "redirect:addsuccess?id=" + request.getId();
		}		
	}
	
	@RequestMapping(value = "/im/addsuccess", method = RequestMethod.GET)
	public String addSuccess(ModelMap model, @RequestParam("id") Integer id) {
		logger.info("addSuccess(): ");
		
		setSuccessMessage(model, "Dodano incident.");
		
		return showForm(model, id);
	}
	
	
	@RequestMapping(value = "/im/search", method = RequestMethod.GET)
	public String searchGET(ModelMap model) {
		logger.info("searchGET(): ");
		
		model.addAttribute("requests", null);
		model.addAttribute("requestSearchCriteria", new RequestSearchCriteria());
		
		return "im/search";
	}

	@RequestMapping(value = "/im/search", method = RequestMethod.POST)
	public String searchPOST(ModelMap model, @ModelAttribute("requestSearchCriteria") RequestSearchCriteria requestSearchCriteria) {
		logger.info("searchPOST(): " + requestSearchCriteria);
		
		Set<Request> result = requestService.search(requestSearchCriteria);
		model.addAttribute("requests", result);
		
		return "im/search";
	}
	
	@ModelAttribute("priorities")
	public List<RequestPriority> populatePriorities() {
		logger.info("populatePriorities(): ");
		
		return requestService.getAllPriorities();
	}

	@ModelAttribute("statuses")
	public List<RequestStatus> populateStatuses() {
		logger.info("populateStatuses(): ");
		
		return requestService.getAllStatuses();
	}
	
	@ModelAttribute("impacts")
	public List<RequestImpact> populateImpacts() {
		logger.info("populateImpacts(): ");
		
		return requestService.getAllImpacts();
	}
	
	private void setSuccessMessage(ModelMap model, String message) {
		model.addAttribute("succesmessage", message);
	}
	
	
	
	
	@RequestMapping(value = "/im/test", method = RequestMethod.POST)
	public String onSubmitAdd(@ModelAttribute("helper") TestIncidents test) {
		logger.info(test.getIncidents());
		
		return "im/edit";		
	}
}
