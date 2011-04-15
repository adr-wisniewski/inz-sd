<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">b66a1a2b-bc4d-42ec-9f49-02c900800955</identifier>
  </ID>
  <name>C2_AUTOINSERT_EMPLOYEES</name>
  <code>BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;PRACOWNIK #&apos; || to_char(:employee.EMPLOYEE_ID));

    INSERT INTO C2_ITEMS_EMPLOYEE (ITEM_ID, EMPLOYEE_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :employee.EMPLOYEE_ID);
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
  </events>
  <referencingNewAs>employee</referencingNewAs>
  <schema>
    <name>CMDB</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER c2_autoinsert_employees
    AFTER INSERT ON employees
    REFERENCING NEW AS employee
    FOR EACH ROW
BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;PRACOWNIK #&apos; || to_char(:employee.EMPLOYEE_ID));

    INSERT INTO C2_ITEMS_EMPLOYEE (ITEM_ID, EMPLOYEE_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :employee.EMPLOYEE_ID);
END;</source>
  <statementLevel>false</statementLevel>
  <timing>AFTER</timing>
</trigger>
