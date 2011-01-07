package sd.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sd.app.EmployeeSearchCriteria;
import sd.dao.EmployeeDao;
import sd.dao.RoleDao;
import sd.domain.Employee;
import sd.domain.Role;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Autowired
	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Employee getCurrentUser() {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		return employeeDao.findByLogin(login);
	}

	public Employee findById(Integer employeeId) {
		return employeeDao.findById(employeeId);
	}

	public List<Employee> search(EmployeeSearchCriteria employeeSearchCriteria) {
		return employeeDao.search(employeeSearchCriteria);
	}

	public List<Role> findAllRoles() {
		return roleDao.fetchAll();
	}

	public void setRoles(Employee employee, Set<String> roles) {
		employee.clearAuthorities();
		
		List<Role> authorities = new LinkedList<Role>();
		for(String roleCode : roles) {
			authorities.add(roleDao.findByCode(roleCode));
		}
		employee.setAuthorities(authorities);
		employeeDao.save(employee);
	}
	
	public Employee getSystem() {
		return employeeDao.findByLogin("SYSTEM");
	}

}
