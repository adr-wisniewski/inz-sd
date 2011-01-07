package sd.im.editor;

import java.beans.PropertyEditorSupport;

import sd.im.dao.SupportGroupDao;

public class SupportGroupEditor extends PropertyEditorSupport{
	
	private SupportGroupDao supportGroupDao;
	
	public SupportGroupEditor(SupportGroupDao supportGroupDao) {
		super();
		this.supportGroupDao = supportGroupDao;
	}

	public void setAsText(String text) {
		try {
			setValue(supportGroupDao.get(Integer.parseInt(text)));
		}
		catch(NumberFormatException e) {
			setValue(null);
		}
	}
}