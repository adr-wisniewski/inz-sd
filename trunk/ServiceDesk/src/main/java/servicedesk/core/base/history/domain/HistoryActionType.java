package servicedesk.core.base.history.domain;

public enum HistoryActionType {
	STATUS("STATUS.HISTORY"),
	CREATION("CREATION.HISTORY"),
	CLOSURE("CLOSURE.HISTORY"),
	IMPACT("IMPACT.HISTORY"),
	URGENCY("URGENCY.HISTORY"),
	SUPPORT_GROUP("SUPPORT_GROUP.HISTORY"),
	STAFF_MEMBER("STAFF_MEMBER.HISTORY"),
	PRIORITY("PRIORITY.HISTORY"),
	SUBJECT("SUBJECT.HISTORY"),
	DESCRIPTION("DESCRIPTION.HISTORY"),
	RESOLUTION("RESOLUTION.HISTORY"),
	CATEGORY("CATEGORY.HISTORY"),
	CLOSURE_DATE("CLOSURE_DATE.HISTORY"),
	RESOLUTION_DATE("RESOLUTION_DATE.HISTORY"),
	TARGET_RESOLUTION_DATE("TARGET_RESOLUTION_DATE.HISTORY"),
        SERVICE("SERVICE.HISTORY");
	
	private HistoryActionType(String descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

	private final String descriptionCode;

	public String getDescriptionCode() {
		return descriptionCode;
	}
}
