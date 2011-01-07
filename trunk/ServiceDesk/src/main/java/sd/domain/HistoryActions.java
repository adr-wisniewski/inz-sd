package sd.domain;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HistoryActions {
	/** kto dokonal zmiany */
	private Employee employee;
	/** data zmiany */
	private Date eventDate;
	/** lista akcji */
	private List<HistoryAction> actions = new LinkedList<HistoryAction>();
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public List<HistoryAction> getActions() {
		return Collections.unmodifiableList(actions);
	}
	
	public void addAction(HistoryAction action) {
		actions.add(action);
	}
}
