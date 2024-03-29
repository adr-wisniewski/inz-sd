package servicedesk.core.base.employee.editor;

import java.beans.PropertyEditorSupport;

import servicedesk.core.base.employee.dao.EmployeeDao;

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
