package sd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sd.im.service.IncidentService;

@Controller
public class SupportGroupController {
	public static final String DETAILS_ACTION = "/sd/groupDetails";
	
	public static final String DETAILS_VIEW_NAME = "sd/groupDetails";
	
	@Autowired
	private IncidentService incidentService;
	
	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}

	@RequestMapping(value=DETAILS_ACTION, method=RequestMethod.GET)
	public String details(ModelMap model, @RequestParam("id") Integer groupId) {
		model.addAttribute("group", incidentService.getGroupById(groupId));
		return DETAILS_VIEW_NAME;
	}
}
