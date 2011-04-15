package servicedesk.scm.editor;

import java.beans.PropertyEditorSupport;

import servicedesk.scm.dao.ServiceDao;

public class ServiceEditor extends PropertyEditorSupport {
	
	private ServiceDao serviceDao;
	
	public ServiceEditor(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public void setAsText(String text) {
		try {
			setValue(serviceDao.get(Integer.parseInt(text)));
		}
		catch(NumberFormatException e) {
			setValue(null);
		}
	}
}
