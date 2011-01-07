package sd.scm.editor;

import java.beans.PropertyEditorSupport;

import sd.scm.dao.ServiceDao;

public class ServiceEditor extends PropertyEditorSupport {
	
	private ServiceDao serviceDao;
	
	public ServiceEditor(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public void setAsText(String text) {
		try {
			setValue(serviceDao.findById(Integer.parseInt(text)));
		}
		catch(NumberFormatException e) {
			setValue(null);
		}
	}
}
