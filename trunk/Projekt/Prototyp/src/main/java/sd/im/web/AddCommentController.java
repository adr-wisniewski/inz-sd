package sd.im.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sd.im.app.RequestService;
import sd.im.app.Comment;
import sd.im.validator.CommentValidator;

@Controller
@SessionAttributes("comment")
public class AddCommentController {
	@Autowired
	private CommentValidator commentValidator;
	@Autowired
	private RequestService requestService;

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
	
	public void setCommentValidator(CommentValidator commentValidator) {
		this.commentValidator = commentValidator;
	}


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@RequestMapping(value="/im/comment", method = RequestMethod.GET)
	public String showForm(ModelMap model, @RequestParam("requestId") Integer requestId) {
		Comment comment = new Comment();
		comment.setRequestId(requestId);
		model.addAttribute("comment", comment);
		return "im/comment";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param request
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@RequestMapping(value="/im/comment", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("request") Comment comment, BindingResult result) {
		commentValidator.validate(comment, result);
		if(result.hasErrors()) {
			return "im/comment";
		}
		else {
			requestService.addComment(comment);
			return "redirect:commentsuccessold";
			//return "redirect:comment";
		}
	}
	
	@RequestMapping(value="/im/commentsuccessold")
	public String success() {
		return "im/commentsuccess";
	}
}
