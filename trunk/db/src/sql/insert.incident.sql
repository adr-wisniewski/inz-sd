insert into impact_types_im(impact_code, name) values ('AU', 'Affects user');
insert into impact_types_im(impact_code, name) values ('AG', 'Affects Group');
insert into impact_types_im(impact_code, name) values ('AD', 'Affects Department');
insert into impact_types_im(impact_code, name) values ('AB', 'Affects Business');

insert into urgency_types_im(urgency_code, name) values('H', 'High');
insert into urgency_types_im(urgency_code, name) values('L', 'Low');
insert into urgency_types_im(urgency_code, name) values('U', 'Urgent');
insert into urgency_types_im(urgency_code, name) values('N', 'Normal');

insert into priority_types_im(priority_code, name, target_resolution_time) values('H', 'High', 1);
insert into priority_types_im(priority_code, name, target_resolution_time) values('L', 'Low', 48);
insert into priority_types_im(priority_code, name, target_resolution_time) values('M', 'Medium', 8);
insert into priority_types_im(priority_code, name, target_resolution_time) values('N', 'Normal', 24);
/*
insert into request_types(request_type_code, name) values('I', 'Incident');
insert into request_types(request_type_code, name) values('SR', 'Service Request');
insert into request_types(request_type_code, name) values('H', 'How-to');
*/
insert into statuses_im(status_code, name) values('OPEN', 'Open');
insert into statuses_im(status_code, name) values('OH', 'On Hold');
insert into statuses_im(status_code, name) values('RESO', 'Resolved');
insert into statuses_im(status_code, name) values('CLOS', 'Closed');

insert into SOURCE_TYPES_IM(SOURCE_code, name) values('PHON', 'Phone call');
insert into SOURCE_TYPES_IM(SOURCE_code, name) values('FORM', 'Web form');
insert into SOURCE_TYPES_IM(SOURCE_code, name) values('MAIL', 'E-Mail');
insert into SOURCE_TYPES_IM(SOURCE_code, name) values('EVNT', 'Event');

insert into categories_im(category_code, group_id, name, parent_category) values('SOFT', NULL, 'Software', NULL);
insert into categories_im(category_code, group_id, name, parent_category) values('APPL', NULL, 'Business Application', 'SOFT');

insert into categories_im(category_code, group_id, name, parent_category) values('APPE', NULL, 'ERP', 'APPL');
insert into categories_im(category_code, group_id, name, parent_category) values('APPC', NULL, 'CRM', 'APPL');

insert into categories_im(category_code, group_id, name, parent_category) values('EXPL', NULL, 'Explorer', 'SOFT');
insert into categories_im(category_code, group_id, name, parent_category) values('BROW', NULL, 'Browser', 'SOFT');
insert into categories_im(category_code, group_id, name, parent_category) values('IEXP', NULL, 'Internet explorer', 'BROW');
insert into categories_im(category_code, group_id, name, parent_category) values('IEV6', NULL, 'Internet explorer 6', 'IEXP');
insert into categories_im(category_code, group_id, name, parent_category) values('IEV7', NULL, 'Internet explorer 7', 'IEXP');
insert into categories_im(category_code, group_id, name, parent_category) values('FIRE', NULL, 'Mozilla firefox', 'BROW');
insert into categories_im(category_code, group_id, name, parent_category) values('FIR2', NULL, 'Mozilla firefox 2.x', 'FIRE');
insert into categories_im(category_code, group_id, name, parent_category) values('FIR3', NULL, 'Mozilla firefox 3.x', 'FIRE');
insert into categories_im(category_code, group_id, name, parent_category) values('OPER', NULL, 'Opera', 'BROW');

insert into categories_im(category_code, group_id, name, parent_category) values('MAIL', NULL, 'E-MAIL', 'SOFT');

insert into categories_im(category_code, group_id, name, parent_category) values('HARD', NULL, 'Hardware', NULL);
insert into categories_im(category_code, group_id, name, parent_category) values('WOST', NULL, 'Work Station', 'HARD');
insert into categories_im(category_code, group_id, name, parent_category) values('MAFR', NULL, 'Mainframe', 'HARD');
insert into categories_im(category_code, group_id, name, parent_category) values('PRIN', NULL, 'Printer', 'HARD');
insert into categories_im(category_code, group_id, name, parent_category) values('SCAN', NULL, 'Scanner', 'HARD');
insert into categories_im(category_code, group_id, name, parent_category) values('PHON', NULL, 'Phone', 'HARD');
insert into categories_im(category_code, group_id, name, parent_category) values('SERV', NULL, 'Server', 'HARD');

insert into categories_im(category_code, group_id, name, parent_category) values('DBDB', NULL, 'Database', 'SOFT');
insert into categories_im(category_code, group_id, name, parent_category) values('ORAC', NULL, 'Oracle', 'DBDB');
insert into categories_im(category_code, group_id, name, parent_category) values('PGSQ', NULL, 'PostgreSQL', 'DBDB');
