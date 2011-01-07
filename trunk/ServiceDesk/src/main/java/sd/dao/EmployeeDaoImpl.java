package sd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.domain.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl extends GenericHibernateDao<Employee> implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(Employee.class);
	}
	
	
	public Employee findById(Integer employeeId) {
		List<Employee> result = findByNamedQuery("Employee.findById", employeeId);
		return result.get(0);
	}

	public Employee findByLogin(String login) {
		List<Employee> result = findByNamedQuery("Employee.findByLogin", login);
		return result.get(0);
	}
}
