package servicedesk.core.base.signal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.hr.dao.EmployeeDao;
import servicedesk.infrastructure.dao.hibernate.GenericHibernateDao;
import servicedesk.core.hr.domain.Employee;
import servicedesk.core.base.signal.domain.Signal;
import servicedesk.core.base.signal.domain.SignalGenerator;
import servicedesk.core.base.signal.mapper.SignalMapper;

@Repository
@Transactional
public class SignalDaoImpl extends GenericHibernateDao<Signal,Integer> implements SignalDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmployeeDao employeeDao;


    @SuppressWarnings("deprecation")
    @Override
    public List<Signal> generateSignals(SignalGenerator generator) {
            SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);
            return template.query(generator.getQuery(), new SignalMapper(generator.getType(), employeeDao));
    }

    public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
    }

    @Override
    public List<Signal> fetchSignalsToSendEmail() {
            return this.findByNamedQuery("Signal.email");
    }

    @Override
    public List<Signal> getSignalsForEmployee(Employee employee) {
            return this.findByNamedQuery("Signal.findByEmployee", employee);
    }
}
