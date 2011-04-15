insert into EVENT_SIGNIFICANCE_TYPES(significance_code, name) values('INFO', 'Informational');
insert into EVENT_SIGNIFICANCE_TYPES(significance_code, name) values('WARN', 'Warning');
insert into EVENT_SIGNIFICANCE_TYPES(significance_code, name) values('EXCE', 'Exception');

insert into categories_em(category_code, name, parent_category) values('SOFT', 'Software', NULL);
insert into categories_em(category_code, name, parent_category) values('APPL', 'Business Application', 'SOFT');

insert into categories_em(category_code, name, parent_category) values('HARD', 'Hardware', NULL);
insert into categories_em(category_code, name, parent_category) values('WOST', 'Work Station', 'HARD');
insert into categories_em(category_code, name, parent_category) values('MAFR', 'Mainframe', 'HARD');
