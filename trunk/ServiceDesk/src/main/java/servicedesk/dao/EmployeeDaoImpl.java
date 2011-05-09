package servicedesk.dao;

import java.util.List;
import org.springframework.dao.support.DataAccessUtils;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.domain.Employee;
import servicedesk.infrastructure.security.domain.User;

@Repository
@Transactional
public class EmployeeDaoImpl extends GenericHibernateDao<Employee, Integer> implements EmployeeDao {

    @Override
    public Employee get(Integer employeeId) {
            List<Employee> result = findByNamedQuery("Employee.get", employeeId);
            return result.get(0);
    }

    @Override
    public Employee findByLogin(String login) {
            List<User> result = getSession().getNamedQuery("User.findByLogin").setParameter("login", login).list();
            return DataAccessUtils.singleResult(result).getEmployee();
    }
}
