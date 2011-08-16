package servicedesk.core.base.employee.dao;

import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.EmployeeUser;

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
        @SuppressWarnings("unchecked")
            List<EmployeeUser> result = getSession().getNamedQuery("EmployeeUser.findByLogin").setParameter("login", login).list();
            return DataAccessUtils.singleResult(result).getEmployee();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = getSession().createCriteria(Employee.class).list();
        return list;
    }
}
