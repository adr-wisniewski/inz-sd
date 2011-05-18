<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">c617ac2e-6ac7-42f9-87d1-ff7fc656c7c6</identifier>
  </ID>
  <name>INCIDENT_SIGNALS_TRG</name>
  <baseType>TABLE</baseType>
  <code>BEGIN
  IF :old.STATUS_CODE &lt;&gt; :new.STATUS_CODE THEN
    --powiadomienie autora o zmianie statusu
    insert into signals_tmp(type_code, employee_id, object_id) values(1, :new.AUTHOR, :new.INCIDENT_ID);
  END IF;
  
  IF coalesce(:old.STAFF_MEMBER,-1) &lt;&gt; coalesce(:new.STAFF_MEMBER,-1) THEN
    IF :old.STAFF_MEMBER is not NULL THEN
       --powiadomienie serwisanta o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(11, :old.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
    IF :new.STAFF_MEMBER is not NULL THEN
        --powiadomienie serwisanta o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(10, :new.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
  END IF;
  
  IF coalesce(:old.GROUP_ID,-1) &lt;&gt; coalesce(:new.GROUP_ID,-1) THEN
    IF :old.GROUP_ID is not NULL THEN    
       --powiadomienie menedzera grupy o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(13, (select manager_id from support_groups where group_id = :old.GROUP_ID), :new.INCIDENT_ID);
    END IF;
    IF :new.GROUP_ID is not NULL THEN
        --powiadomienie menedzera grupy o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(12, (select manager_id from support_groups where group_id = :new.GROUP_ID), :new.INCIDENT_ID);
    END IF;
  END IF;
  
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
    <event>UPDATE</event>
  </events>
  <schema>
    <name>SD3</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER INCIDENT_SIGNALS_TRG 
BEFORE INSERT OR UPDATE ON INCIDENTS 
FOR EACH ROW 
BEGIN
  IF :old.STATUS_CODE &lt;&gt; :new.STATUS_CODE THEN
    --powiadomienie autora o zmianie statusu
    insert into signals_tmp(type_code, employee_id, object_id) values(1, :new.AUTHOR, :new.INCIDENT_ID);
  END IF;
  
  IF coalesce(:old.STAFF_MEMBER,-1) &lt;&gt; coalesce(:new.STAFF_MEMBER,-1) THEN
    IF :old.STAFF_MEMBER is not NULL THEN
       --powiadomienie serwisanta o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(11, :old.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
    IF :new.STAFF_MEMBER is not NULL THEN
        --powiadomienie serwisanta o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(10, :new.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
  END IF;
  
  IF coalesce(:old.GROUP_ID,-1) &lt;&gt; coalesce(:new.GROUP_ID,-1) THEN
    IF :old.GROUP_ID is not NULL THEN    
       --powiadomienie menedzera grupy o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(13, (select manager_id from support_groups where group_id = :old.GROUP_ID), :new.INCIDENT_ID);
    END IF;
    IF :new.GROUP_ID is not NULL THEN
        --powiadomienie menedzera grupy o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(12, (select manager_id from support_groups where group_id = :new.GROUP_ID), :new.INCIDENT_ID);
    END IF;
  END IF;
  
END;</source>
  <statementLevel>false</statementLevel>
  <tableID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">1a82df75-c4bd-4208-8265-d48fe7230208</identifier>
    <type>TABLE</type>
  </tableID>
  <timing>BEFORE</timing>
</trigger>
