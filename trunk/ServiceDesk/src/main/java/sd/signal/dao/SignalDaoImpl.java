package sd.signal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sd.dao.EmployeeDao;
import sd.dao.GenericHibernateDao;
import sd.domain.Employee;
import sd.signal.domain.Signal;
import sd.signal.domain.SignalGenerator;
import sd.signal.mapper.SignalMapper;

@Repository
@Transactional
public class SignalDaoImpl extends GenericHibernateDao<Signal,Integer> implements SignalDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private EmployeeDao employeeDao;
	
	public SignalDaoImpl() {
		super(Signal.class, Integer.class);
	}
	
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

	public List<Signal> fetchSignalsToSendEmail() {
		return this.findByNamedQuery("Signal.email");
	}

	public List<Signal> getSignalsForEmployee(Employee employee) {
		return this.findByNamedQuery("Signal.findByEmployee", employee);
	}
}
