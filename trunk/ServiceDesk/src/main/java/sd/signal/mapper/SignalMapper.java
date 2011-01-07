package sd.signal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import sd.dao.EmployeeDao;
import sd.signal.domain.Signal;
import sd.signal.domain.SignalAttribute;
import sd.signal.domain.SignalObjectAttributeType;
import sd.signal.domain.SignalType;


public class SignalMapper implements ParameterizedRowMapper<Signal> {

	private SignalType signalType;
	private EmployeeDao employeeDao;
	
	public SignalMapper(SignalType signalType, EmployeeDao employeeDao) {
		this.signalType = signalType;
		this.employeeDao = employeeDao;
	}

	public Signal mapRow(ResultSet rs, int rownNum) throws SQLException {
		Signal signal = new Signal();
		
		signal.setCreationDate(new Date());
		signal.setReceiver(employeeDao.get(rs.getInt("employee_id")));
		signal.setType(signalType);
		signal.setSent(false);
		signal.setObjectId(rs.getInt(signalType.getObjectType().getIdColumnName()));
		
		for(SignalObjectAttributeType at : signalType.getObjectType().getAttributeTypes()) {
			SignalAttribute sa = new SignalAttribute();
			sa.setAttributeType(at);
			sa.setSignal(signal);
			sa.setValue(rs.getString(at.getName()));
			signal.addAttribute(sa);
		}
		
		return signal;
	}

}
