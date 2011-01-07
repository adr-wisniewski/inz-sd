package sd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sd.service.EmployeeService;
import sd.signal.service.SignalService;

@Controller
public class DashboardController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SignalService signalService;
	
	@RequestMapping(value = "/sd/dashboard")
	public String dashboard(ModelMap model) {
		model.addAttribute("signals", signalService.getSignalsForEmployee(employeeService.getCurrentUser()));
		return "sd/dashboard";
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setSignalService(SignalService signalService) {
		this.signalService = signalService;
	}
}
