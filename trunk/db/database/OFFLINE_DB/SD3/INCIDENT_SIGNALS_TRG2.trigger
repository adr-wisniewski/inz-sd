<?xml version = '1.0' encoding = 'UTF-8'?>
<trigger xmlns="http://xmlns.oracle.com/jdeveloper/1111/offlinedb">
  <ID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">bd375631-0041-422e-be1a-0097cf34c649</identifier>
  </ID>
  <name>INCIDENT_SIGNALS_TRG2</name>
  <baseType>TABLE</baseType>
  <code>BEGIN
  FOR s IN (SELECT * FROM SIGNALS_TMP) LOOP
    ADD_SIGNAL(s.type_code, s.employee_id, s.object_id);
  END LOOP;
END;</code>
  <enabled>true</enabled>
  <events>
    <event>INSERT</event>
    <event>UPDATE</event>
  </events>
  <schema>
    <name>SD3</name>
  </schema>
  <source>CREATE OR REPLACE TRIGGER INCIDENT_SIGNALS_TRG2 
AFTER INSERT OR UPDATE ON INCIDENTS 
BEGIN
  FOR s IN (SELECT * FROM SIGNALS_TMP) LOOP
    ADD_SIGNAL(s.type_code, s.employee_id, s.object_id);
  END LOOP;
END;</source>
  <statementLevel>true</statementLevel>
  <tableID class="oracle.javatools.db.IdentifierBasedID">
    <identifier class="java.lang.String">1a82df75-c4bd-4208-8265-d48fe7230208</identifier>
    <type>TABLE</type>
  </tableID>
  <timing>AFTER</timing>
</trigger>
