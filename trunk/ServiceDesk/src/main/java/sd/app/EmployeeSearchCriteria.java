package sd.app;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import sd.domain.Employee;

public class EmployeeSearchCriteria implements SearchCriteria<Employee> {

	private Integer id;
	
	private String firstname;
	
	private String lastname;

	private String login;
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String buildCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initCriteria(Criteria criteria) {
		if(id != null) criteria.add(Restrictions.eq("id", id));
		if(firstname != null) criteria.add(Restrictions.like("firstname", "%" + firstname + "%"));
		if(lastname != null) criteria.add(Restrictions.like("lastname", "%" + lastname + "%"));
		if(login != null) criteria.add(Restrictions.like("login", "%" + login + "%"));
	}

	public boolean match(Employee event) {
		// TODO Auto-generated method stub
		return false;
	}

}
