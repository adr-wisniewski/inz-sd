package servicedesk.core.base.signal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.signal.dao.SignalDao;
import servicedesk.core.base.signal.domain.Signal;

@Service
@Transactional
public class SignalServiceImpl implements SignalService {
	@Autowired(required=false)
	private MailSender mailSender;
	@Autowired(required=false)
	private SimpleMailMessage templateMessage;
	@Autowired
	private SignalDao signalDao;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
	
	public void setSignalDao(SignalDao signalDao) {
		this.signalDao = signalDao;
	}

	public void sendEmailForSignals() {
		for(Signal s : signalDao.fetchSignalsToSendEmail()) {
			sendEmail(s);
		}
	}
	
	private void sendEmail(Signal s) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        //msg.setTo(s.getReceiver().getEmail());
		msg.setTo("piokal.test1@gmail.com");
        msg.setText(s.getMessage());
        msg.setSubject(s.getSubject());
        try{
            this.mailSender.send(msg);
            s.setSent(true);
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            s.setErrorMessage(ex.getMessage());
        }
        finally {
        	signalDao.save(s);
        }
	}

	public List<Signal> getSignalsForEmployee(Employee employee) {
		return signalDao.getSignalsForEmployee(employee);
	}

}
