package servicedesk.web;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import servicedesk.app.EmployeeSearchCriteria;
import servicedesk.domain.Employee;
import servicedesk.domain.Role;
import servicedesk.service.EmployeeService;
import servicedesk.util.CheckboxSelection;
import servicedesk.util.FormUtils;

@Controller
@SessionAttributes({"employee", "selection", "employeeSearchCriteria"})
public class EmployeeController {
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	public static final String EDIT_SUCCESS = "/servicedesk/editEmployeeSuccess";
	
	public static final String SEARCH_ACTION = "/servicedesk/searchEmployee";
	
	public static final String SEARCH_VIEW_NAME = "servicedesk/searchEmployee";
	
	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/servicedesk/employeeDetails", method = RequestMethod.GET)
	public String details(ModelMap map, @RequestParam("id") Integer employeeId) {
		Employee employee = employeeService.get(employeeId);
		map.addAttribute("employee", employee);

		map.addAttribute("roles", employeeService.findAllRoles());
		Set<String> selected = new HashSet<String>();
		for(Role r : employee.getAuthorities()) {
			selected.add(r.getCode());
		}
		CheckboxSelection selection = new CheckboxSelection();
		selection.setSelected(selected);
		map.addAttribute("selection", selection);
		
		return "servicedesk/employeeDetails";
	}
	
	@RequestMapping(value = "/servicedesk/editPrivileges", method = RequestMethod.POST)
	public String editPrivileges(@ModelAttribute("employee") Employee employee, @ModelAttribute("selection") CheckboxSelection selection) {
		employeeService.setRoles(employee, selection.getSelected());
		return "redirect:" + EDIT_SUCCESS + "?id=" + employee.getId();
	}
	
	@RequestMapping(value = EDIT_SUCCESS, method = RequestMethod.GET)
	public String onEditSuccess(ModelMap map, @RequestParam("id") Integer employeeId) {
		FormUtils.setSuccessMessage("edit_employee_success", map);
		return details(map, employeeId);
	}
	
	@RequestMapping(value = SEARCH_ACTION, method = RequestMethod.GET)
	public String showSearchForm(ModelMap map) {
		map.addAttribute("employeeSearchCriteria", new EmployeeSearchCriteria());
		map.addAttribute("employees", null);
		return SEARCH_VIEW_NAME;
	}
	
	/**
	 * Akcja wykonywana po wyszukaniu pracownika
	 * 
	 * @param map atrybuty
	 * @param employeeSearchCriteria kryterium wyszukiwania pracownikow
	 * @return
	 */
	@RequestMapping(value = SEARCH_ACTION, method = RequestMethod.POST)
	public String showForm(ModelMap map, @ModelAttribute("employeeSearchCriteria") EmployeeSearchCriteria employeeSearchCriteria) {
		map.addAttribute("employees", employeeService.search(employeeSearchCriteria));
		return SEARCH_VIEW_NAME;
	}
	
}
