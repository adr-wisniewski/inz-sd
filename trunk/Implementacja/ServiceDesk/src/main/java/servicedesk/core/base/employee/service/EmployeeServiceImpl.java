package servicedesk.core.base.employee.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.base.employee.domain.EmployeeSearchCriteria;
import servicedesk.core.base.employee.dao.EmployeeDao;
import servicedesk.core.base.security.dao.RoleDao;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.Role;

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

    @Override
    public Employee getCurrentUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return employeeDao.findByLogin(login);
    }

    @Override
    public Employee get(Integer employeeId) {
        return employeeDao.get(employeeId);
    }

    @Override
    public List<Employee> search(EmployeeSearchCriteria employeeSearchCriteria) {
        return employeeDao.search(employeeSearchCriteria);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.getAll();
    }

    @Override
    public void setRoles(Employee employee, Set<String> roles) {
        employee.clearAuthorities();

        List<Role> authorities = new LinkedList<Role>();
        for (String roleCode : roles) {
            authorities.add(roleDao.findByCode(roleCode));
        }
        employee.setAuthorities(authorities);
        employeeDao.save(employee);
    }

    @Override
    public Employee getSystem() {
        return employeeDao.findByLogin("SYSTEM");
    }
}
