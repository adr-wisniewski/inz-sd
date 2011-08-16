/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.base.employee.domain.Employee;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="EMPLOYEE_USERS")
@PrimaryKeyJoinColumn(name="USER_ID")
@NamedQueries({
    @NamedQuery(name = "EmployeeUser.findByLogin", query = "from EmployeeUser as u where u.login = :login")
})
public class EmployeeUser extends User {

    private Employee employee;
    
    @Transient
    @Override
    public Person getPerson() {
        return getEmployee();
    }

    /**
     * @return the employee
     */
    
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, updatable=false)
    @OneToOne(fetch=FetchType.EAGER)
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
    public <R,C> R accept(UserVisitor<R,C> visitor, C context) {
        return visitor.visit(this, context);
    }
    
}
