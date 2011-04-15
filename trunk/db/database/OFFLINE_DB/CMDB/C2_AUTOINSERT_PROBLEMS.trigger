<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">acb7d6b2-be7d-4b92-8107-be5879073fc1</identifier>
  </ID>
  <name>C2_AUTOINSERT_PROBLEMS</name>
  <code>BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;PROBLEM #&apos; || to_char(:problem.PROBLEM_ID));

    INSERT INTO C2_ITEMS_PROBLEM (ITEM_ID, PROBLEM_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :problem.PROBLEM_ID);
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
  </events>
  <referencingNewAs>problem</referencingNewAs>
  <schema>
    <name>CMDB</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER c2_autoinsert_problems
    AFTER INSERT ON problems
    REFERENCING NEW AS problem
    FOR EACH ROW
BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, &apos;PROBLEM #&apos; || to_char(:problem.PROBLEM_ID));

    INSERT INTO C2_ITEMS_PROBLEM (ITEM_ID, PROBLEM_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :problem.PROBLEM_ID);
END;</source>
  <statementLevel>false</statementLevel>
  <timing>AFTER</timing>
</trigger>
