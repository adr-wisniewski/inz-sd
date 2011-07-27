package servicedesk.web.base.signal;

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

import servicedesk.core.base.signal.domain.SignalGenerator;
import servicedesk.core.base.signal.domain.SignalReceiverType;
import servicedesk.core.base.signal.domain.SignalType;
import servicedesk.core.base.signal.service.SignalGeneratorService;
import servicedesk.core.base.signal.validator.SignalGeneratorValidator;
import servicedesk.web.base.util.FormUtils;

@Controller
@SessionAttributes({"generator"})
public class SignalGeneratorController {
	public static final String ADD_GENERATOR_ACTION = "/signal/addgenerator";
	
	public static final String ADD_GENERATOR_SUCCESS = "/signal/addgeneratorsuccess";
	
	public static final String ADD_GENERATOR_VIEW = "signal/addgenerator";
	
	public static final String EDIT_GENERATOR_ACTION = "/signal/editgenerator";
	
	public static final String EDIT_GENERATOR_SUCCESS = "/signal/editgeneratorsuccess";
	
	public static final String EDIT_GENERATOR_VIEW = "signal/editgenerator";
	
	public static final String LIST_GENERATOR_ACTION = "/signal/generatorlist";
	
	public static final String LIST_GENERATOR_VIEW = "signal/generatorlist";
	
	public static final String PREVIEW_ACTION = "/signal/preview";
	
	public static final String PREVIEW_VIEW = "signal/preview";
	
	@Autowired
	private PropertyEditorRegistrar propertyEditorRegistrar;
	
	@Autowired
	private SignalGeneratorService signalGeneratorService;
	
	@Autowired
	private SignalGeneratorValidator signalGeneratorValidator;
	
	@RequestMapping(value=ADD_GENERATOR_ACTION, method=RequestMethod.GET)
	public String addGeneratorShowForm(ModelMap model) {
		model.addAttribute("generator", new SignalGenerator());
		model.addAttribute("action_name", "addgenerator");
		return EDIT_GENERATOR_VIEW;
	}
	
	
	@RequestMapping(value=EDIT_GENERATOR_ACTION, method=RequestMethod.GET)
	public String editGeneratorShowForm(ModelMap model, @RequestParam(value="id") Integer generatorId) {
		model.addAttribute("generator", signalGeneratorService.getById(generatorId));
		model.addAttribute("action_name", "editgenerator");
		return EDIT_GENERATOR_VIEW;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		propertyEditorRegistrar.registerCustomEditors(binder);
	}

	@RequestMapping(value=LIST_GENERATOR_ACTION, method=RequestMethod.GET)
	public String listGenerators(ModelMap model) {
		model.addAttribute("generators", signalGeneratorService.getAll());
		return LIST_GENERATOR_VIEW;
	}

	@RequestMapping(value=ADD_GENERATOR_ACTION, method=RequestMethod.POST)
	public String onAddGenerator(ModelMap model, @ModelAttribute(value="generator") SignalGenerator generator, BindingResult result) {
		signalGeneratorValidator.validate(generator, result);
		if(result.hasErrors()) {
			model.addAttribute("action_name", "addgenerator");
			return ADD_GENERATOR_VIEW;
		}
		else {
			signalGeneratorService.add(generator);
			return "redirect:" + ADD_GENERATOR_SUCCESS + "?id=" + generator.getId();
		}
	}
	
	@RequestMapping(value=ADD_GENERATOR_SUCCESS, method=RequestMethod.GET)
	public String onAddTypeSuccess(ModelMap model, @RequestParam(value="id") Integer generatorId) {
		FormUtils.setSuccessMessage("addgeneratorsuccess", model);
		return editGeneratorShowForm(model, generatorId);
	}
	
	@RequestMapping(value=EDIT_GENERATOR_ACTION, method=RequestMethod.POST)
	public String onEditGenerator(ModelMap model, @ModelAttribute(value="generator") SignalGenerator generator, BindingResult result) {
		signalGeneratorValidator.validate(generator, result);
		if(result.hasErrors()) {
			model.addAttribute("action_name", "editgenerator");
			return EDIT_GENERATOR_VIEW;
		}
		else {
			signalGeneratorService.edit(generator);
			return "redirect:" + EDIT_GENERATOR_SUCCESS + "?id=" + generator.getId();
		}
	}
	
	@RequestMapping(value=EDIT_GENERATOR_SUCCESS, method=RequestMethod.GET)
	public String onEditGeneratorSuccess(ModelMap model, @RequestParam(value="id") Integer generatorId) {
		FormUtils.setSuccessMessage("editgeneratorsuccess", model);
		return editGeneratorShowForm(model, generatorId);
	}
	
	@RequestMapping(value=PREVIEW_ACTION, method=RequestMethod.GET)
	public String preview(ModelMap model, @RequestParam(value="id") Integer generatorId) {
		SignalGenerator g = signalGeneratorService.getById(generatorId);
		model.addAttribute("signals", signalGeneratorService.getSignals(g));
		return PREVIEW_VIEW;
	}
	
	public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
		this.propertyEditorRegistrar = propertyEditorRegistrar;
	}
	
	public void setSignalGeneratorService(SignalGeneratorService signalGeneratorService) {
		this.signalGeneratorService = signalGeneratorService;
	}
	
	public void setSignalGeneratorValidator(SignalGeneratorValidator signalGeneratorValidator) {
		this.signalGeneratorValidator = signalGeneratorValidator;
	}
	
	@ModelAttribute(value="signal_types")
	public List<SignalType> populateSignalTypes() {
		return signalGeneratorService.getAllSignalTypes();
	}
	
	@ModelAttribute(value="receiver_types")
	public List<SignalReceiverType> populateReceiverTypes() {
		return signalGeneratorService.getAllSignalReceiverTypes();
	}
}
