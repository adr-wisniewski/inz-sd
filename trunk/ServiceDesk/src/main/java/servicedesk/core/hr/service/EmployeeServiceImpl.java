package servicedesk.core.hr.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.hr.domain.EmployeeSearchCriteria;
import servicedesk.core.hr.dao.EmployeeDao;
import servicedesk.infrastructure.security.dao.RoleDao;
import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.security.domain.Role;

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

	public Employee get(Integer employeeId) {
		return employeeDao.get(employeeId);
	}

	public List<Employee> search(EmployeeSearchCriteria employeeSearchCriteria) {
		return employeeDao.search(employeeSearchCriteria);
	}

	public List<Role> findAllRoles() {
		return roleDao.getAll();
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
