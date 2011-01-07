package sd.rf.web;

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

import sd.rf.app.RequestSearchCriteria;
import sd.rf.domain.RequestPriority;
import sd.rf.domain.RequestStatus;
import sd.rf.service.RequestService;

@Controller
@SessionAttributes({"requests"})
public class SearchRequestController {
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
	
	@RequestMapping(value="/rf/search", method=RequestMethod.GET)
	public String search(ModelMap model) {
		model.addAttribute("requestSearchCriteria", new RequestSearchCriteria());
		//model.addAttribute("requests", null);
		return "rf/search";
	}
	
	@RequestMapping(value="/rf/search", method=RequestMethod.POST)
	public String onSearch(ModelMap model, @ModelAttribute("requestSearchCriteria") RequestSearchCriteria searchCriteria) {
		model.addAttribute("requests", requestService.search(searchCriteria));
		return "rf/search";
	}
	
	@ModelAttribute("priorities")
	public List<RequestPriority> populatePriorities() {
		return requestService.getAllPriorities();
	}
	
	@ModelAttribute("statuses")
	public List<RequestStatus> populateStatuses() {
		return requestService.getAllStatuses();
	}
}
