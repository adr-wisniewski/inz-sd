package sd.signal.jobs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class AbstractJob {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	final public void execute() {
		boolean participate = false;
		
		if(TransactionSynchronizationManager.hasResource(sessionFactory)) {
			participate = true;
		}
		else {
			Session session = sessionFactory.openSession();
			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
		}
		
		doExecute();
		
		if(!participate) {
			SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
			Session session = sessionHolder.getSession();
			session.flush();
			session.close();
		}
	}

	protected abstract void doExecute();
}
