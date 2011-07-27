package servicedesk.core.base.employee.service;

import java.util.List;
import java.util.Set;

import servicedesk.core.base.employee.domain.EmployeeSearchCriteria;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.Role;

public interface EmployeeService {
	/**
	 * @return zwraca aktualnie zalogowane pracownika
	 */
	public Employee getCurrentUser();
	
	/**
	 * Wyszukuje pracownika po id
	 * 
	 * @param employeeId identyfikator pracownika
	 * @return pracownik
	 */
	public Employee get(Integer employeeId);
	
	/**
	 * Wyszukuje pracownikow po kryterium
	 * 
	 * @param employeeSearchCriteria kryterium wyszukiwania pracownikow
	 * @return lista pracownikow spelniajacych kryterium
	 */
	public List<Employee> search(EmployeeSearchCriteria employeeSearchCriteria);
	
	/**
	 * @return Zwraca liste wszystkich uprawnien
	 */
	public List<Role> findAllRoles();

	/**
	 * Ustawia uprawnienia dla pracownika
	 * 
	 * @param employee pracownik
	 * @param roles lista uprawnien
	 */
	public void setRoles(Employee employee, Set<String> roles);

	/**
	 * 
	 * @return zwraca uzytkownika reprezentujacego system
	 */
	public Employee getSystem();
}
