CREATE OR REPLACE TRIGGER INCIDENT_SIGNALS_TRG 
BEFORE INSERT OR UPDATE ON INCIDENTS 
FOR EACH ROW 
BEGIN
  IF :old.STATUS_CODE <> :new.STATUS_CODE THEN
    --powiadomienie autora o zmianie statusu
    insert into signals_tmp(type_code, employee_id, object_id) values(1, :new.AUTHOR, :new.INCIDENT_ID);
  END IF;
  
  IF coalesce(:old.STAFF_MEMBER,-1) <> coalesce(:new.STAFF_MEMBER,-1) THEN
    IF :old.STAFF_MEMBER is not NULL THEN
       --powiadomienie serwisanta o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(11, :old.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
    IF :new.STAFF_MEMBER is not NULL THEN
        --powiadomienie serwisanta o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(10, :new.STAFF_MEMBER, :new.INCIDENT_ID);
    END IF;
  END IF;
  
  IF coalesce(:old.GROUP_ID,-1) <> coalesce(:new.GROUP_ID,-1) THEN
    IF :old.GROUP_ID is not NULL THEN    
       --powiadomienie menedzera grupy o odpisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(13, (select manager_id from support_groups where group_id = :old.GROUP_ID), :new.INCIDENT_ID);
    END IF;
    IF :new.GROUP_ID is not NULL THEN
        --powiadomienie menedzera grupy o przypisaniu incydentu
       insert into signals_tmp(type_code, employee_id, object_id) values(12, (select manager_id from support_groups where group_id = :new.GROUP_ID), :new.INCIDENT_ID);
    END IF;
  END IF;
  
END;
/
