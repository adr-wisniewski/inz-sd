package servicedesk.editor;

import java.beans.PropertyEditorSupport;

import servicedesk.dao.EmployeeDao;

public class EmployeeEditor extends PropertyEditorSupport{
	
    private EmployeeDao employeeDao;

    public EmployeeEditor(EmployeeDao employeeDao) {
            super();
            this.employeeDao = employeeDao;
    }

    @Override
    public void setAsText(String text) {
            try {
                    setValue(employeeDao.get(Integer.parseInt(text)));
            }
            catch(NumberFormatException e) {
                    setValue(null);
            }
    }
}
