<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">40637335-5040-499e-ad5b-97621da7ff6b</identifier>
  </ID>
  <name>C2_AUTOINSERT_INCIDENTS</name>
  <code>BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;INCYDENT #&apos; || to_char(:incident.INCIDENT_ID));

    INSERT INTO C2_ITEMS_INCIDENT (ITEM_ID, INCIDENT_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :incident.INCIDENT_ID);
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
  </events>
  <referencingNewAs>incident</referencingNewAs>
  <schema>
    <name>CMDB</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER c2_autoinsert_incidents
    AFTER INSERT ON incidents
    REFERENCING NEW AS incident
    FOR EACH ROW
BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;INCYDENT #&apos; || to_char(:incident.INCIDENT_ID));

    INSERT INTO C2_ITEMS_INCIDENT (ITEM_ID, INCIDENT_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :incident.INCIDENT_ID);
END;</source>
  <statementLevel>false</statementLevel>
  <timing>AFTER</timing>
</trigger>
