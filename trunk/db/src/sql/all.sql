set feedback off
alter session set nls_date_language='AMERICAN';
PROMPT === CREATING DATABASE ===
@creates.sql
PROMPT === INSERTING DATA ===
@inserts.sql
PROMPT === ALL DONE ===