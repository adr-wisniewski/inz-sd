package servicedesk.core.base.employee.domain;

import servicedesk.infrastructure.interfaces.domain.SearchCriteria;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class EmployeeSearchCriteria implements SearchCriteria<Employee> {

	private Integer id;
	
	private String firstname;
	
	private String lastname;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String buildCondition() {
		// TODO2 Auto-generated method stub
		return null;
	}

    @Override
    public void initCriteria(Criteria criteria) {
            if(id != null) criteria.add(Restrictions.eq("id", id));
            if(firstname != null) criteria.add(Restrictions.like("firstname", "%" + firstname + "%"));
            if(lastname != null) criteria.add(Restrictions.like("lastname", "%" + lastname + "%"));
    }

    @Override
    public boolean match(Employee event) {
            // TODO2 Auto-generated method stub
            return false;
    }

}
