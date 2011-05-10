create table AuditRevisionEntity (
        id number(10,0) not null,
        timestamp number(19,0) not null,
        employee number(10,0),
        primary key (id)
);

create table RFC_AUD (
	RFC_ID number(10,0) not null,
	REV number(10,0) not null,
	REVTYPE number(3,0),
	STATE number(10,0),
	IMPACT number(10,0),
	MANAGER number(10,0),
	PRIORITY number(10,0),
	primary key (RFC_ID, REV)
);

alter table AuditRevisionEntity 
        add constraint AuditRevisionEntity_FK1 
        foreign key (REV) 
        references AuditRevisionEntity;

alter table RFC_AUD 
        add constraint FK6D0E8AE0102D5E83 
        foreign key (REV) 
        references AuditRevisionEntity;