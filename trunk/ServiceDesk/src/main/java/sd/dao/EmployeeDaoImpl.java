package sd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.domain.Employee;

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
            List<Employee> result = findByNamedQuery("Employee.findByLogin", login);
            return result.get(0);
    }
}
