insert into categories_rf(category_code, name, parent_category) values('SOFT', 'Software', NULL);
insert into categories_rf(category_code, name, parent_category) values('APPL', 'Business Application', 'SOFT');
insert into categories_rf(category_code, name, parent_category) values('INST', 'Install new software', 'APPL');
insert into categories_rf(category_code, name, parent_category) values('PATC', 'Install patch', 'APPL');
insert into categories_rf(category_code, name, parent_category) values('UINS', 'Uninstall software', 'APPL');

insert into categories_rf(category_code, name, parent_category) values('MAIL', 'E-Mail', 'SOFT');
insert into categories_rf(category_code, name, parent_category) values('EMAL', 'Create alias', 'MAIL');

insert into categories_rf(category_code, name, parent_category) values('HARD', 'Hardware', NULL);
insert into categories_rf(category_code, name, parent_category) values('WOST', 'Work Station', 'HARD');
insert into categories_rf(category_code, name, parent_category) values('WSUP', 'Upgrade work station', 'WOST');


insert into request_attribute_types(category_code, input_type, name, required, type_code) values('INST', 'text', 'Application', 't', 'INSTAP');
insert into request_attribute_types(category_code, input_type, name, required, type_code) values('INST', 'text', 'Version', 't', 'INSTVE');

insert into request_attribute_types(category_code, input_type, name, required, type_code) values('PATC', 'text', 'Application', 't', 'PATCAP');
insert into request_attribute_types(category_code, input_type, name, required, type_code) values('PATC', 'text', 'Patch', 't', 'PATCPA');

insert into request_attribute_types(category_code, input_type, name, required, type_code) values('UINS', 'text', 'Application', 't', 'UINSAP');

insert into request_attribute_types(category_code, input_type, name, required, type_code) values('WSUP', 'text', 'Component', 't', 'WSUPCO');
insert into request_attribute_types(category_code, input_type, name, required, type_code) values('WSUP', 'text', 'New component', 't', 'WSUPNE');

insert into request_attribute_types(category_code, input_type, name, required, type_code) values('EMAL', 'text', 'Adress', 't', 'EMALA1');
insert into request_attribute_types(category_code, input_type, name, required, type_code) values('EMAL', 'text', 'Alias', 't', 'EMALA2');

insert into statuses_rf(status_code, name) values('OPEN', 'Open');
insert into statuses_rf(status_code, name) values('CLOS', 'Closed');

insert into priority_types_rf(priority_code, name, target_resolution_time) values('H', 'High', 1);
insert into priority_types_rf(priority_code, name, target_resolution_time) values('L', 'Low', 48);
insert into priority_types_rf(priority_code, name, target_resolution_time) values('M', 'Medium', 8);
insert into priority_types_rf(priority_code, name, target_resolution_time) values('N', 'Normal', 24);

