SPOOL "sql.delete.log";

drop user sd cascade;
create user sd identified by sd;

GRANT connect TO sd;
GRANT resource TO sd;
GRANT create table TO sd;
GRANT create type TO sd;
GRANT create view TO sd;
GRANT create sequence TO sd;
GRANT create trigger TO sd;
GRANT create procedure TO sd;

commit;
SPOOL OFF;

EXIT