/*package sd.cmdb.domain.old;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import sd.domain.Employee;

@Entity
@DiscriminatorValue("EMP")
public class EmployeeItem {
	private Employee employee;

	void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employee getEmployee() {
		return employee;
	}
	
	
}
 *
 */
