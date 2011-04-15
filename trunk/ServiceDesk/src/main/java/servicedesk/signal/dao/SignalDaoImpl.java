package servicedesk.signal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.dao.EmployeeDao;
import servicedesk.dao.GenericHibernateDao;
import servicedesk.domain.Employee;
import servicedesk.signal.domain.Signal;
import servicedesk.signal.domain.SignalGenerator;
import servicedesk.signal.mapper.SignalMapper;

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
