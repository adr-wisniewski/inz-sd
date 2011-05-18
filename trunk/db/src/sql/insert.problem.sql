
insert into impact_types_pm(impact_code, name) values ('AU', 'Affects user');
insert into impact_types_pm(impact_code, name) values ('AG', 'Affects Group');
insert into impact_types_pm(impact_code, name) values ('AD', 'Affects Department');
insert into impact_types_pm(impact_code, name) values ('AB', 'Affects Business');

insert into urgency_types_pm(urgency_code, name) values('H', 'High');
insert into urgency_types_pm(urgency_code, name) values('L', 'Low');
insert into urgency_types_pm(urgency_code, name) values('U', 'Urgent');
insert into urgency_types_pm(urgency_code, name) values('N', 'Normal');

insert into priority_types_pm(priority_code, name) values('H', 'High');
insert into priority_types_pm(priority_code, name) values('L', 'Low');
insert into priority_types_pm(priority_code, name) values('M', 'Medium');
insert into priority_types_pm(priority_code, name) values('N', 'Normal');

insert into statuses_pm(status_code, name) values('OPEN', 'Open');
insert into statuses_pm(status_code, name) values('OH', 'On Hold');
insert into statuses_pm(status_code, name) values('RESO', 'Resolved');
insert into statuses_pm(status_code, name) values('CLOS', 'Closed');

insert into categories_pm(category_code, group_id, name, parent_category) values('SOFT', NULL, 'Software', NULL);
insert into categories_pm(category_code, group_id, name, parent_category) values('WORD', NULL, 'Word processing', 'SOFT');
insert into categories_pm(category_code, group_id, name, parent_category) values('SPRE', NULL, 'Spreadsheet', 'SOFT');
insert into categories_pm(category_code, group_id, name, parent_category) values('APPL', NULL, 'Business Application', 'SOFT');
insert into categories_pm(category_code, group_id, name, parent_category) values('EXPL', NULL, 'Explorer', 'SOFT');
insert into categories_pm(category_code, group_id, name, parent_category) values('BROW', NULL, 'Browser', 'SOFT');

insert into categories_pm(category_code, group_id, name, parent_category) values('HARD', NULL, 'Hardware', NULL);
insert into categories_pm(category_code, group_id, name, parent_category) values('WOST', NULL, 'Work Station', 'HARD');
insert into categories_pm(category_code, group_id, name, parent_category) values('MAFR', NULL, 'Mainframe', 'HARD');
insert into categories_pm(category_code, group_id, name, parent_category) values('PRIN', NULL, 'Printer', 'HARD');
insert into categories_pm(category_code, group_id, name, parent_category) values('SCAN', NULL, 'Scanner', 'HARD');
insert into categories_pm(category_code, group_id, name, parent_category) values('PHON', NULL, 'Phone', 'HARD');

insert into categories_pm(category_code, group_id, name, parent_category) values('DBDB', NULL, 'Database', 'SOFT');
insert into categories_pm(category_code, group_id, name, parent_category) values('ORAC', NULL, 'Oracle', 'DBDB');
insert into categories_pm(category_code, group_id, name, parent_category) values('PGSQ', NULL, 'PostgreSQL', 'DBDB');

insert into solution_types(solution_code, name) values('WORK', 'Workaround');
insert into solution_types(solution_code, name) values('PERM', 'Permanent');