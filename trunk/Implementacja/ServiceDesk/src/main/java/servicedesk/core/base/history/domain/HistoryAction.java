/**
 * 
 */
package servicedesk.core.base.history.domain;


/** 
 * Klasa reprezentujaca zmiane wartosci atrybutu.
 * @author Piotr Kalanski
 */
public class HistoryAction {
	private String beforeValue;
	private String afterValue;
	private HistoryActionType actionType;
	
	public HistoryAction(String beforeValue, String afterValue, HistoryActionType actionType) {
		super();
		this.beforeValue = beforeValue;
		this.afterValue = afterValue;
		this.actionType = actionType;
	}
	
	public String getBeforeValue() {
		return beforeValue;
	}
	
	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}
	
	public String getAfterValue() {
		return afterValue;
	}
	
	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}

	public HistoryActionType getActionType() {
		return actionType;
	}

	public void setActionType(HistoryActionType actionType) {
		this.actionType = actionType;
	}
}