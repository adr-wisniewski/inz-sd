package sd.signal.web;

import java.util.List;

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

import sd.signal.domain.SignalObjectType;
import sd.signal.domain.SignalSignificanceType;
import sd.signal.domain.SignalType;
import sd.signal.service.SignalTypeService;
import sd.signal.validator.SignalTypeValidator;
import sd.util.FormUtils;

@Controller
@SessionAttributes({"signal_type"})
public class SignalController {
	
	public static final String ADD_TYPE_ACTION = "/signal/addtype";
	
	public static final String ADD_TYPE_SUCCESS = "/signal/addtypesuccess";
	
	public static final String ADD_TYPE_VIEW = "signal/addtype";
	
	public static final String EDIT_TYPE_ACTION = "/signal/edittype";
	
	public static final String EDIT_TYPE_SUCCESS = "/signal/edittypesuccess";
	
	public static final String EDIT_TYPE_VIEW = "signal/edittype";
	
	public static final String LIST_TYPES_ACTION = "/signal/typelist";
	
	public static final String LIST_TYPES_VIEW = "signal/typelist";
	

	@Autowired
	private PropertyEditorRegistrar propertyEditorRegistrar;
	
	@Autowired
	private SignalTypeService signalTypeService;

	@Autowired
	private SignalTypeValidator signalTypeValidator;
	
	@RequestMapping(value=ADD_TYPE_ACTION, method=RequestMethod.GET)
	public String addTypeShowForm(ModelMap model) {
		model.addAttribute("signal_type", new SignalType());
		model.addAttribute("action_name", "addtype");
		return EDIT_TYPE_VIEW;
	}

	@RequestMapping(value=EDIT_TYPE_ACTION, method=RequestMethod.GET)
	public String editTypeShowForm(ModelMap model, @RequestParam(value="code") SignalType signalType) {
		model.addAttribute("signal_type", signalType);
		model.addAttribute("action_name", "edittype");
		return EDIT_TYPE_VIEW;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		propertyEditorRegistrar.registerCustomEditors(binder);
	}

	@RequestMapping(value=LIST_TYPES_ACTION, method=RequestMethod.GET)
	public String listTypes(ModelMap model) {
		model.addAttribute("signal_types", signalTypeService.getAll());
		return LIST_TYPES_VIEW;
	}
	
	@RequestMapping(value=ADD_TYPE_ACTION, method=RequestMethod.POST)
	public String onAddType(ModelMap model, @ModelAttribute(value="signal_type") SignalType signalType, BindingResult result) {
		signalTypeValidator.validate(signalType, result);
		if(result.hasErrors()) {
			model.addAttribute("action_name", "addtype");
			return ADD_TYPE_VIEW;
		}
		else {
			signalTypeService.add(signalType);
			return "redirect:" + ADD_TYPE_SUCCESS + "?code=" + signalType.getCode();
		}
	}
	
	@RequestMapping(value=ADD_TYPE_SUCCESS, method=RequestMethod.GET)
	public String onAddTypeSuccess(ModelMap model, @RequestParam(value="code") SignalType signalType) {
		FormUtils.setSuccessMessage("addtypesuccess", model);
		return editTypeShowForm(model, signalType);
	}
	
	@RequestMapping(value=EDIT_TYPE_ACTION, method=RequestMethod.POST)
	public String onEditType(ModelMap model, @ModelAttribute(value="signal_type") SignalType signalType, BindingResult result) {
		signalTypeValidator.validate(signalType, result);
		if(result.hasErrors()) {
			model.addAttribute("action_name", "edittype");
			return EDIT_TYPE_VIEW;
		}
		else {
			signalTypeService.edit(signalType);
			return "redirect:" + EDIT_TYPE_SUCCESS + "?code=" + signalType.getCode();
		}
	}
	
	@RequestMapping(value=EDIT_TYPE_SUCCESS, method=RequestMethod.GET)
	public String onEditTypeSuccess(ModelMap model, @RequestParam(value="code") SignalType signalType) {
		FormUtils.setSuccessMessage("edittypesuccess", model);
		return editTypeShowForm(model, signalType);
	}
	
	@ModelAttribute(value="object_types")
	public List<SignalObjectType> populateObjectTypes() {
		return signalTypeService.getAllObjectTypes();
	}
	
	@ModelAttribute(value="significance_types")
	public List<SignalSignificanceType> populateSignificanceTypes() {
		return signalTypeService.getAllSignificanceTypes();
	}
	
	public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
		this.propertyEditorRegistrar = propertyEditorRegistrar;
	}
	
	public void setSignalTypeService(SignalTypeService signalTypeService) {
		this.signalTypeService = signalTypeService;
	}
	
	public void setSignalTypeValidator(SignalTypeValidator signalTypeValidator) {
		this.signalTypeValidator = signalTypeValidator;
	}
}
