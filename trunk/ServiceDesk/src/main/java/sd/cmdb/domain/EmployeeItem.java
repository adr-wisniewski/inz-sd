/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import sd.cmdb.domain.helper.ItemVisitor;
import sd.domain.Employee;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_EMPLOYEE")
public class EmployeeItem extends Item {

    private Employee employee;
    private EmployeeItemClass employeeItemClass;

    /**
     * @return the employee
     */
    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
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
}
