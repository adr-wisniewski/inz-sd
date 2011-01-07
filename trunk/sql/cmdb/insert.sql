insert into "ROLES" ("ROLE_CODE", "DESCRIPTION") values('CMDB_MAN', 'Configuration Management Database Manager');
insert into "ROLES" ("ROLE_CODE", "DESCRIPTION") values('CMDB_ADMIN', 'Configuration Management Database Administrator');

insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('MENU_CMDB', 'Menu bazy konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('MENU_CMDBA', 'Menu administracji bazy konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('VIE_CD_ITM', 'Przegl¹danie elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('ADD_CD_ITM', 'Dodawania elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('EDI_CD_ITM', 'Edycja elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('ADD_CD_ITT', 'Dodawanie typów elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('EDI_CD_ITT', 'Edycja typów elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('ADD_CD_AST', 'Dodawanie typów asocjacji elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('EDI_CD_AST', 'Edycja typów asocjacji elementów konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('ADD_CD_EUT', 'Dodawanie typów atrybutów wyliczeniowych konfiguracji');
insert into "PRIVILEGE_TYPES" ("PRIVILEGE_CODE", "DESCRIPTION") values('EDI_CD_EUT', 'Edycja typów atrybutów wyliczeniowych konfiguracji');

insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_MAN', 'MENU_CMDB');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_MAN', 'VIE_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_MAN', 'ADD_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_MAN', 'EDI_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'MENU_CMDB');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'MENU_CMDBA');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'VIE_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'ADD_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'EDI_CD_ITM');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'ADD_CD_ITT');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'EDI_CD_ITT');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'ADD_CD_AST');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'EDI_CD_AST');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'ADD_CD_EUT');
insert into "ROLE_PRIVILEGE" ("ROLE_CODE", "PRIVILEGE_CODE") values('CMDB_ADMIN', 'EDI_CD_EUT');

insert into "EMPLOYEES" ("EMPLOYEE_ID", "NAME", "SURNAME", "PHONE_NUMBER", "MOBILE_PHONE", "EMAIL", "LOGIN", "PASSWORD", "ENABLED", "MANAGER_ID", "DEPARTMENT_ID", "JOB_CODE") values(200000, 'CMDB_MAN', 'CMDB_MAN', '1111', '1111', 'CMDB_MAN@firma.com.pl', 'CMDB_MAN', 'CMDB_MAN', 1, null, null, null);
insert into "EMPLOYEES" ("EMPLOYEE_ID", "NAME", "SURNAME", "PHONE_NUMBER", "MOBILE_PHONE", "EMAIL", "LOGIN", "PASSWORD", "ENABLED", "MANAGER_ID", "DEPARTMENT_ID", "JOB_CODE") values(200001, 'CMDB_ADMIN', 'CMDB_ADMIN', '1111', '1111', 'CMDB_ADMIN@firma.com.pl', 'CMDB_ADMIN', 'CMDB_ADMIN', 1, null, null, null);

insert into "EMPLOYEE_ROLE" ("EMPLOYEE_ID", "ROLE_CODE") values(200000, 'CMDB_MAN');
insert into "EMPLOYEE_ROLE" ("EMPLOYEE_ID", "ROLE_CODE") values(200001, 'CMDB_ADMIN');
