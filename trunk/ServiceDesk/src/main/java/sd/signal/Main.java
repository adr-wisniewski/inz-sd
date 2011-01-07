package sd.signal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import sd.signal.service.SignalGeneratorService;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/jobs.xml");
/*		
		SessionFactory sessionFactory =  (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
		
		SignalGeneratorService service = (SignalGeneratorService)context.getBean("signalGeneratorServiceImpl");
		
		service.generateSignals();
		
		session.flush();
		session.close();
*/		
	}

}
