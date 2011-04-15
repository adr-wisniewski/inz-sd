<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">bd1b7249-40fc-476d-a3a4-b11a4a60b75d</identifier>
  </ID>
  <name>C2_AUTOINSERT_SERVICES</name>
  <code>BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;USŁUGA #&apos; || to_char(:service.SERVICE_ID));

    INSERT INTO C2_ITEMS_SERVICE (ITEM_ID, SERVICE_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :service.SERVICE_ID);
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
  </events>
  <referencingNewAs>service</referencingNewAs>
  <schema>
    <name>CMDB</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER c2_autoinsert_services
    AFTER INSERT ON services
    REFERENCING NEW AS service
    FOR EACH ROW
BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;USŁUGA #&apos; || to_char(:service.SERVICE_ID));

    INSERT INTO C2_ITEMS_SERVICE (ITEM_ID, SERVICE_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :service.SERVICE_ID);
END;</source>
  <statementLevel>false</statementLevel>
  <timing>AFTER</timing>
</trigger>
