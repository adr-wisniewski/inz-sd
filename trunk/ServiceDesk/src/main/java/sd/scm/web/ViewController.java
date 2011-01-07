package sd.scm.web;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sd.scm.domain.Service;
import sd.scm.service.ServiceService;

@Controller
public class ViewController {
	protected static final String VIEW_NAME = "scm/serviceDetails";
	protected static final String ACTION_NAME = "/scm/serviceDetails";
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private PropertyEditorRegistrar propertyEditorRegistrar;
	
	public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
		this.propertyEditorRegistrar = propertyEditorRegistrar;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		propertyEditorRegistrar.registerCustomEditors(binder);
	}
	
	@RequestMapping(value = ACTION_NAME, method = RequestMethod.GET)
	public String details(ModelMap map, @RequestParam("id") Integer serviceId) {
		Service service = serviceService.get(serviceId);
		map.addAttribute("service", service);

		return VIEW_NAME;
	}
}
