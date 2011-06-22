set feedback off
alter session set nls_date_language='AMERICAN';
@insert.incident.sql
@insert.problem.sql
@insert.event.sql
@insert.roles.sql           
@insert.privilege_types.sql
@insert.role_privilege.sql
@insert.requests.sql
@insert.signals.sql
@insert.scm-slm.sql
@insert.jobs.sql
@insert.departments.sql
@insert.employees.sql
@insert.users.sql
@insert.user_roles.sql
@insert.support_groups.sql
@insert.services.sql

@insert.cmdb.itemclass.sql
@insert.cmdb.relationshipclass.sql
@insert.cmdb.items.sql

@insert.change.rfc.sql

commit;