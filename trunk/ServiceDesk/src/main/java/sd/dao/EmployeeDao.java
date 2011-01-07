package sd.dao;

import java.util.List;

import sd.app.SearchCriteria;
import sd.domain.Employee;

public interface EmployeeDao {
	/**
	 * Wyszukuje pracownika po id
	 * 
	 * @param employeeId id pracownika
	 * @return pracownik
	 */
	public Employee get(Integer employeeId);
	
	/**
	 * Wyszukuje pracownika po loginie
	 * 
	 * @param login login pracownika
	 * @return pracownik
	 */
	public Employee findByLogin(String login);
	
	/**
	 * Wyszukuje pracownikow po kryterium
	 * 
	 * @param employeeSearchCriteria kryterium wyszukiwania pracownikow
	 * @return lista pracownikow spelniajacych kryterium
	 */
	public List<Employee> search(SearchCriteria<Employee> employeeSearchCriteria);
	
	/**
	 * Zapisuje dane pracownika
	 * 
	 * @param employee pracownik
	 */
	public void save(Employee employee);
}
