package servicedesk.web;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.common.announcement.service.AnnouncementService;

import servicedesk.service.EmployeeService;
import servicedesk.signal.service.SignalService;

@Controller
public class DashboardController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SignalService signalService;

        @Autowired
        protected AnnouncementService announcementService;
	
	@RequestMapping(value = "/servicedesk/dashboard")
	public String dashboard(ModelMap model) {
                model.addAttribute("announcements", announcementService.getUpToDate(new Date()));
		model.addAttribute("signals", signalService.getSignalsForEmployee(employeeService.getCurrentUser()));
		return "servicedesk/dashboard";
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setSignalService(SignalService signalService) {
		this.signalService = signalService;
	}
}