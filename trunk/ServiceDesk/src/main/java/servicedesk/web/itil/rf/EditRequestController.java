package servicedesk.web.itil.rf;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import servicedesk.core.base.comment.domain.Comment;
import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.rf.domain.RequestAttribute;
import servicedesk.core.itil.rf.domain.RequestAttributeType;
import servicedesk.core.itil.rf.domain.RequestCategory;
import servicedesk.core.itil.rf.domain.RequestPriority;
import servicedesk.core.itil.rf.domain.RequestStatus;
import servicedesk.core.itil.rf.domain.ServiceRequest;
import servicedesk.core.itil.rf.service.RequestService;
import servicedesk.core.itil.rf.validator.EditRequestValidator;
import servicedesk.web.base.tree.TreeBuilder;
import servicedesk.web.base.util.FormUtils;
import servicedesk.core.base.comment.validator.CommentValidator;

@Controller
@SessionAttributes({"request", "comment"})
public class EditRequestController {

    @Resource(name = "rfCategoriesTree")
    protected TreeBuilder<?> rfCategoriesTree;
    /** 
     * <!-- begin-UML-doc -->
     * Nazwa&nbsp;widoku&nbsp;formularza
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    protected static final String VIEW_NAME = "rf/edit";
    /** 
     * <!-- begin-UML-doc -->
     * Nazwa&nbsp;akcji&nbsp;do&nbsp;edycji
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    protected static final String EDIT_ACTION_NAME = "/rf/edit";
    /** 
     * <!-- begin-UML-doc -->
     * Nazwa&nbsp;akcji&nbsp;dla&nbsp;sukcesu&nbsp;edycji
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    protected static final String EDIT_SUCCESS_ACTION_NAME = "/rf/editsuccess";
    /** 
     * <!-- begin-UML-doc -->
     * Nazwa&nbsp;akcji&nbsp;dokonujacej&nbsp;dodania&nbsp;komentarza
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    protected static final String COMMENT_ACTION_NAME = "/rf/addcomment";
    /** 
     * <!-- begin-UML-doc -->
     * Nazwa&nbsp;akcji&nbsp;dla&nbsp;przypadku,&nbsp;gdy&nbsp;pomyslanie&nbsp;dodano&nbsp;komentarz
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    protected static final String COMMENT_SUCCESS_NAME = "/rf/commentsuccess";
    @Autowired
    private EditRequestValidator validator;

    public void setValidator(EditRequestValidator validator) {
        this.validator = validator;
    }
    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Autowired
    private CommentValidator commentValidator;

    /** 
     * /**
     *  * @param commentValidator the commentValidator to set
     * 
     * @param commentValidator 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setCommentValidator(CommentValidator commentValidator) {
        // begin-user-code
        this.commentValidator = commentValidator;
        // end-user-code
    }
    @Autowired
    private RequestService requestService;

    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }
    @Autowired
    private PropertyEditorRegistrar propertyEditorRegistrar;

    public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
        this.propertyEditorRegistrar = propertyEditorRegistrar;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        propertyEditorRegistrar.registerCustomEditors(binder);
    }

    @RequestMapping(value = "/rf/category", method = RequestMethod.GET)
    public String chooseCategory(ModelMap model) {
        model.addAttribute("categories", rfCategoriesTree.buildTree());
        return "rf/category";
    }

    private String showForm(ModelMap model, ServiceRequest request) {
        model.addAttribute("request", request);
        return VIEW_NAME;
    }

    @RequestMapping(value = "/rf/add", method = RequestMethod.GET)
    public String add(ModelMap model, @RequestParam("id") RequestCategory category) {
        ServiceRequest request = new ServiceRequest();
        request.setCategory(category);
        List<RequestAttribute> attributes = new LinkedList<RequestAttribute>();
        for (RequestAttributeType type : category.getAttributeTypes()) {
            RequestAttribute attr = new RequestAttribute();
            attr.setAttributeType(type);
            attr.setRequest(request);
            attributes.add(attr);
        }
        request.setAttributes(attributes);
        return showForm(model, request);
    }

    @RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.GET)
    public String edit(ModelMap model, @RequestParam("id") Integer requestId) {
        ServiceRequest request = requestService.getById(requestId);
        model.addAttribute("comment", new Comment());
        return showForm(model, request);
    }

    @RequestMapping(value = EDIT_ACTION_NAME, method = RequestMethod.POST)
    public String onEdit(ModelMap model, @ModelAttribute("request") ServiceRequest request, BindingResult result) {
        validator.validate(request, result);
        if (result.hasErrors()) {
            return VIEW_NAME;
        } else {
            if (request.getId() == null) {
                requestService.add(request);
            } else {
                requestService.edit(request);
            }
            return "redirect:" + EDIT_SUCCESS_ACTION_NAME + "?id=" + request.getId();
        }
    }

    @RequestMapping(value = EDIT_SUCCESS_ACTION_NAME, method = RequestMethod.GET)
    public String editSuccess(ModelMap model, @RequestParam("id") Integer requestId) {
        FormUtils.setSuccessMessage("editsuccess", model);
        return edit(model, requestId);
    }

    @RequestMapping(value = "/rf/addcomment", method = RequestMethod.POST)
    public String onAddComment(@ModelAttribute("request") ServiceRequest request, @ModelAttribute("comment") Comment comment, BindingResult result) {
        commentValidator.validate(comment, result);
        if (result.hasErrors()) {
            return VIEW_NAME;
        } else {
            requestService.addComment(request, comment);
            return "redirect:" + COMMENT_SUCCESS_NAME + "?id=" + request.getId();
        }
    }

    @RequestMapping(value = COMMENT_SUCCESS_NAME, method = RequestMethod.GET)
    public String onCommentSuccess(ModelMap model, @RequestParam("id") Integer requestId) {
        FormUtils.setSuccessMessage("commentsuccess", model);
        return edit(model, requestId);
    }

    @ModelAttribute("priorities")
    public List<RequestPriority> populatePriorities() {
        return requestService.getAllPriorities();
    }

    @ModelAttribute("statuses")
    public List<RequestStatus> populateStatuses() {
        return requestService.getAllStatuses();
    }

    @ModelAttribute("groups")
    public List<SupportGroup> populateGroups() {
        return requestService.getAllGroups();
    }
}
