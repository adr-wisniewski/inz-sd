/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;
import servicedesk.core.hr.domain.Employee;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_EMPLOYEE")
public class EmployeeItem extends Item {
    private static final long serialVersionUID = 1L;
    private Employee employee;
    private EmployeeItemClass employeeItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    @Transient
    public EmployeeItemClass getItemClass() {
        return employeeItemClass;
    }

    public void setItemClass(EmployeeItemClass employeeItemClass) {
        this.employeeItemClass = employeeItemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(employee.getFirstname()).append(" ");
        builder.append(employee.getLastname()).append(" ");
        return builder.toString();
    }
}
