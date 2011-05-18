<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">bfc7e9f7-8ceb-4997-99ef-877e33c2ae85</identifier>
  </ID>
  <name>INCIDENT_HISTORY_TRG</name>
  <baseType>TABLE</baseType>
  <code>DECLARE
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
  
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
    <event>UPDATE</event>
  </events>
  <schema>
    <name>SD3</name>
  </schema>
  <source>create or replace
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
  
END;</source>
  <statementLevel>false</statementLevel>
  <tableID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">1a82df75-c4bd-4208-8265-d48fe7230208</identifier>
    <type>TABLE</type>
  </tableID>
  <timing>AFTER</timing>
</trigger>
