SPOOL "sql.create.log";
alter session set nls_date_language='AMERICAN';
@creates.sql
@inserts.sql
SPOOL OFF;

EXIT