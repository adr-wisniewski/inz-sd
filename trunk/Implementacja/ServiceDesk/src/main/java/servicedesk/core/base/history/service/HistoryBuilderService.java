package servicedesk.core.base.history.service;

import servicedesk.core.hr.domain.Employee;
import java.io.Serializable;
import java.util.Date;
import servicedesk.core.base.history.domain.HistoryAction;
import servicedesk.core.base.history.domain.HistoryActionType;
import servicedesk.core.base.history.domain.HistoryActions;

import servicedesk.core.itil.im.domain.SupportGroup;
import servicedesk.core.itil.scm.domain.Service;
import servicedesk.infrastructure.interfaces.domain.DictionaryProperty;

public class HistoryBuilderService {
	private static final String EMPTY_STRING = "-";
	private HistoryActions actions;
	
	public HistoryBuilderService(HistoryActions actions) {
		super();
		this.actions = actions;
	}

	public <T extends DictionaryProperty<? extends Serializable>> void addAttribute(T before, T after, HistoryActionType actionType) {
		if(before == null && after != null) {
			actions.addAction(new HistoryAction(EMPTY_STRING, after.getName(), actionType));
		}
		else if(before != null && after == null) {
			actions.addAction(new HistoryAction(before.getName(), EMPTY_STRING, actionType));
		}
		else if(before != null && after != null && !before.equals(after)) {
			actions.addAction(new HistoryAction(before.getName(), after.getName(), actionType));
		}
	}
	
	public void addAttribute(String before, String after, HistoryActionType actionType) {
		if(before == null && after != null) {
			actions.addAction(new HistoryAction(EMPTY_STRING, after, actionType));
		}
		else if(before != null && after == null) {
			actions.addAction(new HistoryAction(before, EMPTY_STRING, actionType));
		}
		else if(before != null && after != null && !before.equals(after)) {
			actions.addAction(new HistoryAction(before, after, actionType));
		}
	}
	
	public void addAttribute(Date before, Date after, HistoryActionType actionType) {
		if(before == null && after != null) {
			actions.addAction(new HistoryAction(EMPTY_STRING, after.toString(), actionType));
		}
		else if(before != null && after == null) {
			actions.addAction(new HistoryAction(before.toString(), EMPTY_STRING, actionType));
		}
		else if(before != null && after != null && !before.equals(after)) {
			actions.addAction(new HistoryAction(before.toString(), after.toString(), actionType));
		}
	}
	
	public void addAttribute(Employee before, Employee after, HistoryActionType actionType) {
		String beforeName = EMPTY_STRING;
		if(before != null) {
			beforeName = before.getName();
		}
		String afterName = EMPTY_STRING;
		if(after != null) {
			afterName = after.getName();
		}
		
		addAttribute(beforeName, afterName, actionType);
	}
	
	public void addAttribute(SupportGroup before, SupportGroup after, HistoryActionType actionType) {
		String beforeSupportGroupName = EMPTY_STRING;
		if(before != null) {
			beforeSupportGroupName = before.getName();
		}
		String afterSupportGroupName = EMPTY_STRING;
		if(after != null) {
			afterSupportGroupName = after.getName();
		}
		
		addAttribute(beforeSupportGroupName, afterSupportGroupName, actionType);
	}

        public void addAttribute(Service before, Service after, HistoryActionType actionType) {
		String beforeServiceName = EMPTY_STRING;
		if(before != null) {
			beforeServiceName = before.getName();
		}
		String afterServiceName = EMPTY_STRING;
		if(after != null) {
			afterServiceName = after.getName();
		}

		addAttribute(beforeServiceName, afterServiceName, actionType);
	}
}