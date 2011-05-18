package servicedesk.web.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import servicedesk.core.hr.domain.EmployeeSearchCriteria;
import servicedesk.core.hr.service.EmployeeService;

/**
 * 
 * @author PKalanski
 *
 * Kontroler dla kontrolki do wyboru pracownika.
 * 
 * W pliku /WEB-INF/tags/employeePicker.tag znajduje sie kontrolka do wyboru pracownika.
 * Kontrolka ta po kliknieciu w nazwe pracownika otwiera nowe okna do wyszukania pracownika.
 * Po wyszukaniu pracownika okienko sie zamyka oraz odswieza dane pracownika w oknie nadrzednym.
 * 
 */
@Controller
@SessionAttributes({"employeeSearchCriteria", "name"})
public class EmployeePickerController {
	/**
	 * Nazwa widoku do wyszukiwania pracownikow
	 */
	public static final String VIEW_NAME = "servicedesk/employeePicker";
	/**
	 * Nazwa akcji do wyszukiwania pracownikow
	 */
	public static final String ACTION_NAME = "/servicedesk/employeePicker";
	/**
	 * Nazwa akcji z dokonanym wyborem pracownika
	 */
	public static final String CHOOSE_ACTION_NAME = "/servicedesk/employeePickerChoose";
	/**
	 * Nazwa widoku z dokonanym wyborem pracownika
	 */
	public static final String CHOOSE_VIEW_NAME = "servicedesk/employeePickerChoose";
	
	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * Akcja wykonywana przy pierwszym wejsciu na formularz do wyszukania pracownika
	 * 
	 * @param map atrybuty
	 * @param employeeId obecny identyfikator pracownika
	 * @param name nazwa pola formularza z id pracownika
	 * @return
	 */
	@RequestMapping(value = ACTION_NAME, method = RequestMethod.GET)
	public String showForm(ModelMap map, @RequestParam("name") String name) {
		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		map.addAttribute("employeeSearchCriteria", employeeSearchCriteria);
		map.addAttribute("name", name);
		map.addAttribute("employees", null);
		return VIEW_NAME;
	}
	
	/**
	 * Akcja wykonywana po wyszukaniu pracownika
	 * 
	 * @param map atrybuty
	 * @param employeeSearchCriteria kryterium wyszukiwania pracownikow
	 * @return
	 */
	@RequestMapping(value = ACTION_NAME, method = RequestMethod.POST)
	public String showForm(ModelMap map, @ModelAttribute("employeeSearchCriteria") EmployeeSearchCriteria employeeSearchCriteria) {
		map.addAttribute("employees", employeeService.search(employeeSearchCriteria));
		return VIEW_NAME;
	}
	
	/**
	 * Akcja wykonywana po wyborze konkretnego pracownika
	 * 
	 * @param map atrybuty
	 * @param employeeId identyfikatora wybranego pracownika
	 * @return
	 */
	@RequestMapping(value = CHOOSE_ACTION_NAME, method = RequestMethod.GET)
	public String chooseEmployee(ModelMap map, @RequestParam("id") Integer employeeId) {
		map.addAttribute("employee", employeeService.get(employeeId));
		return CHOOSE_VIEW_NAME;
	}
	
}
