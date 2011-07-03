insert into SIGNAL_SIGNIFICANCE_TYPES(significance_code, name, css_class)  values ('W', 'Warning', 'data-table-alarm1');
insert into SIGNAL_SIGNIFICANCE_TYPES(significance_code, name, css_class)  values ('I', 'Info', 'data-table-noalarm');
insert into SIGNAL_SIGNIFICANCE_TYPES(significance_code, name, css_class)  values ('E', 'Error', 'data-table-alarm2');

insert into signal_object_types(object_code, view_name, id_column_name, name, details_url) values('I', 'incidents_v', 'incident_id', 'Incident', '/im/edit');
insert into signal_object_types(object_code, view_name, id_column_name, name, details_url) values('P', 'problems_v', 'problem_id', 'Problem', '/pm/edit');
insert into signal_object_types(object_code, view_name, id_column_name, name, details_url) values('R', 'requests_v', 'request_id', 'Request', '/rf/edit');

insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISRC', 'SOURCE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISM', 'STAFF_MEMBER');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISG', 'SUPPORT_GROUP');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IID', 'INCIDENT_ID');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISUB', 'SUBJECT');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8D', 'CREATION_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8d', 'CREATION_DAY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8Y', 'CREATION_YEAR');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8M', 'CREATION_MONTH');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8Q', 'CREATION_QUARTER');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IC8m', 'CREATION_MONTH_NAME');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICT1', 'MAIN_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICT2', 'SUB_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICT3', 'SUB_SUB_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICTE', 'CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICLD', 'CLOSURE_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICLY', 'CLOSURE_YEAR');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICLM', 'CLOSURE_MONTH');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICLd', 'CLOSURE_DAY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICLm', 'CLOSURE_MONTH_NAME');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IRSD', 'RESOLUTION_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IRSY', 'RESOLUTION_YEAR');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IRSM', 'RESOLUTION_MONTH');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IRSd', 'RESOLUTION_DAY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IRSm', 'RESOLUTION_MONTH_NAME');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IPRI', 'PRIORITY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISTA', 'STATUS');

insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISGI', 'GROUP_ID');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISTC', 'STATUS_CODE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'IPRC', 'PRIORITY_CODE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ITRD', 'TARGET_RESOLUTION_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ICTC', 'CATEGORY_CODE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('I', 'ISMI', 'STAFF_MEMBER_ID');

insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PID', 'PROBLEM_ID');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSUB', 'SUBJECT');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8D', 'CREATION_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8Y', 'CREATION_YEAR');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8Q', 'CREATION_QUARTER');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8M', 'CREATION_MONTH');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8d', 'CREATION_DAY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PC8m', 'CREATION_MONTH_NAME');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCT1', 'MAIN_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCT2', 'SUB_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCT3', 'SUB_SUB_CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCT0', 'CATEGORY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCLD', 'CLOSURE_DATE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCLY', 'CLOSURE_YEAR');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCLM', 'CLOSURE_MONTH');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCLd', 'CLOSURE_DAY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCLm', 'CLOSURE_MONTH_NAME');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PPRI', 'PRIORITY');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSTA', 'STATUS');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSM', 'STAFF_MEMBER');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSG', 'SUPPORT_GROUP');

insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSGI', 'GROUP_ID');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSMI', 'STAFF_MEMBER_ID');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PSTC', 'STATUS_CODE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PPRC', 'PRIORITY_CODE');
insert into signal_object_attribute_types(object_code, attribute_code, attribute_name) values('P', 'PCTC', 'CATEGORY_CODE');

insert into signal_receiver_types(receiver_code, description, from_statement) values('AUTH', 'Zglaszajacy', 'join employees e on e.employee_id = o.author');
insert into signal_receiver_types(receiver_code, description, from_statement) values('STAF', 'Serwisant', 'join employees e on e.employee_id = o.staff_member_id');
insert into signal_receiver_types(receiver_code, description, from_statement) values('GRMA', 'Menedzer grupy', 'join support_groups sg on sg.group_id = o.group_id join employees e on e.employee_id = sg.manager_id');
--insert into signal_receiver_types(receiver_code, description, from_statement) values('INCM', 'Menedzer incydentow', ', employees e join employee_role er on e.employee_id = er.employee_id and er.role_code = ''INC_MAN''');

--powiadomienia dla autora incydentu:
insert into signal_types(type_code, name, object_code, subject_template, msg_template, significance_code)
values(1, 'Zmiana statusu incydentu', 'I', 'Zmiana statusu', 'Incydent: ${INCIDENT_ID}, temat: ${SUBJECT}, zmienil status na: ${STATUS}.', 'I');
--powiadomienia dla serwisanta incydentu:
insert into signal_types(type_code, name, object_code, subject_template, msg_template,  significance_code)
values(10, 'Przypisano incydent', 'I', 'Nowy incydent', 'Zostal przypisany incydent: ${INCIDENT_ID}, temat: ${SUBJECT}, dodany: ${CREATION_DATE}', 'I');
insert into signal_types(type_code, name, object_code, subject_template, msg_template, significance_code)
values(11, 'Zabrano incydent', 'I', 'Odpisano incydent', 'Incydent: ${INCIDENT_ID}, temat: ${SUBJECT} zostal przypisany innej osobie.', 'I');
--powiadomienia dla menedzera grupy:
insert into signal_types(type_code, name, object_code, subject_template, msg_template,  significance_code)
values(12, 'Przypisano incydent do grupy', 'I', 'Nowy incydent', 'Zostal przypisany incydent do grupy: ${INCIDENT_ID}, temat: ${SUBJECT}, dodany: ${CREATION_DATE}', 'I');
insert into signal_types(type_code, name, object_code, subject_template, msg_template, significance_code)
values(13, 'Zabrano incydent z grupy', 'I', 'Odpisano incydent', 'Incydent: ${INCIDENT_ID}, temat: ${SUBJECT} zostal przypisany innej grupie.', 'I');


Insert into SIGNAL_TYPES (TYPE_CODE,MSG_TEMPLATE,SUBJECT_TEMPLATE,SIGNIFICANCE_CODE,OBJECT_CODE,NAME) values (51,'Incydent: ${INCIDENT_ID}. Powinien zostac rozwiazany: ${TARGET_RESOLUTION_DATE}.','Zblizajacy sie termin rozwiazania incydentu: ${INCIDENT_ID}','W','I','Powiadomienie serwisanta o terminie rozwiazania incydentu.');
Insert into SIGNAL_TYPES (TYPE_CODE,MSG_TEMPLATE,SUBJECT_TEMPLATE,SIGNIFICANCE_CODE,OBJECT_CODE,NAME) values (50,'category: ${CATEGORY} CREATION_YEAR: ${CREATION_YEAR}','source: ${SOURCE} subject: ${SUBJECT} id: ${INCIDENT_ID} category: ${CATEGORY}','W','I','test');
Insert into SIGNAL_TYPES (TYPE_CODE,MSG_TEMPLATE,SUBJECT_TEMPLATE,SIGNIFICANCE_CODE,OBJECT_CODE,NAME) values (52,'Incydent: ${INCIDENT_ID} powinien zostac rozwiazany: ${TARGET_RESOLUTION_DATE}','Zblizajacy sie termin rozwiazania incydentu: ${INCIDENT_ID}','E','I','Powiadomienie managera grupy o terminie rozwiazania incydentu.');

Insert into SIGNAL_TYPES (TYPE_CODE,MSG_TEMPLATE,SUBJECT_TEMPLATE,SIGNIFICANCE_CODE,OBJECT_CODE,NAME) values (53,'Incydent: ${INCIDENT_ID} nie zostal jeszcze pszypisany do pracownika pierwszej linii.','Nie przypisany incydent','W','I','Powiadomienie managera incydentow o nie przypisanym incydencie.');
Insert into SIGNAL_TYPES (TYPE_CODE,MSG_TEMPLATE,SUBJECT_TEMPLATE,SIGNIFICANCE_CODE,OBJECT_CODE,NAME) values (54,'Incydent: ${INCIDENT_ID} nie zostal jeszcze pszypisany do pracownika pierwszej linii.','Nie przypisany incydent','E','I','Powiadomienie managera incydentow o nie przypisanym incydencie.');


Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (1,50,'CREATION_DATE < sysdate','o.*, e.employee_id','STAF','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));
Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (2,51,'TARGET_RESOLUTION_DATE > SYSDATE and TARGET_RESOLUTION_DATE < SYSDATE + 1  and STATUS_CODE not in(''RESO'', ''CLOS'')','o.*, e.employee_id','STAF','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));
Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (3,52,'TARGET_RESOLUTION_DATE > sysdate and TARGET_RESOLUTION_DATE < sysdate + 8/24 and STATUS_CODE not in(''RESO'', ''CLOS'')','o.*, e.employee_id','GRMA','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));
--Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (4,52,'TARGET_RESOLUTION_DATE > sysdate and TARGET_RESOLUTION_DATE < sysdate + 4/24 and STATUS_CODE not in(''RESO'', ''CLOS'') ','o.*, e.employee_id','INCM','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));

--Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (5,53,'o.STAFF_MEMBER IS NULL AND o.CREATION_DATE + 2/24 < SYSDATE','o.*, e.employee_id','INCM','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));
--Insert into SIGNAL_GENERATORS (GENERATOR_ID,TYPE_CODE,CRITERION,SELECT_STATEMENT,RECEIVER_CODE,ENABLED,FREQUENCY,LAST_RUN_STATUS,LAST_RUN_DATE) values (6,54,'o.STAFF_MEMBER IS NULL AND o.CREATION_DATE + 4/24 < SYSDATE','o.*, e.employee_id','INCM','T',10,'T',to_timestamp('11-MAY-10','DD-MON-RR HH.MI.SSXFF AM'));