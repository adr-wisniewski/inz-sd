create or replace
TRIGGER INCIDENT_HISTORY_TRG AFTER INSERT OR UPDATE ON INCIDENTS 
FOR EACH ROW
DECLARE
    history_id_v number;
    employee_id_v number;
BEGIN
  
  
  select HISTORY_ID_SEQ.nextval, app.get_user into history_id_v, employee_id_v from dual;
  
  insert into incidents_history(
    HISTORY_ID
    ,CHANGE_DATE
    ,EMPLOYEE_ID
    ,INCIDENT_ID
    ,IMPACT_CODE
    ,URGENCY_CODE
    ,STATUS_CODE
    ,REVIEW
    ,PRIORITY_CODE
    ,CATEGORY_CODE
    ,SUBJECT
    ,DESCRIPTION
    ,STAFF_MEMBER
    ,RESOLUTION
    ,SOURCE_CODE
    ,RESOLUTION_DATE
    ,GROUP_ID
    ,TARGET_RESOLUTION_DATE
  )
  values(
    history_id_v
    , sysdate
    , employee_id_v
    , :new.INCIDENT_ID
    , :new.IMPACT_CODE
    , :new.URGENCY_CODE
    , :new.STATUS_CODE
    , :new.REVIEW
    , :new.PRIORITY_CODE
    , :new.CATEGORY_CODE
    , :new.SUBJECT
    , :new.DESCRIPTION
    , :new.STAFF_MEMBER
    , :new.RESOLUTION
    , :new.SOURCE_CODE
    , :new.RESOLUTION_DATE
    , :new.GROUP_ID
    , :new.TARGET_RESOLUTION_DATE
  );
  
END;
/
