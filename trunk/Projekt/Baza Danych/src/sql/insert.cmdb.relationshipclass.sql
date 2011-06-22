insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values (1000, 0, 'Y', 'Czynnoœci administracyjne', 'Klasa bazowa dla wszystkich czynnoœci administracyjnych');
insert into C2_RELATION_CLASSES(CLASS_ID, SOURCE_TYPE, TARGET_TYPE, LABEL, LABEL_REVERSE, PARENT_CLASS_ID, SOURCE_CLASS_ID, TARGET_CLASS_ID) 
values (1000, 'EMP', 'UNI', 'Administruje', 'Jest administrowana przez', null, null, 400);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values (1010, 0, 'N', 'Administrator Serwerowni', 'Administrator Serwerowni');
	insert into C2_RELATION_CLASSES(CLASS_ID, SOURCE_TYPE, TARGET_TYPE, LABEL, LABEL_REVERSE, PARENT_CLASS_ID, SOURCE_CLASS_ID, TARGET_CLASS_ID) 
	values (1010, 'EMP', 'UNI', 'Administruje', 'Jest administrowana przez', 1000, null, 410);
	
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values (1100, 0, 'N', 'Licencjonowanie oprogramowania', 'Licencja na oprogramowanie');
insert into C2_RELATION_CLASSES(CLASS_ID, SOURCE_TYPE, TARGET_TYPE, LABEL, LABEL_REVERSE, PARENT_CLASS_ID, SOURCE_CLASS_ID, TARGET_CLASS_ID) 
values (1100, 'UNI', 'UNI', 'Posiada licencjê', 'Obejmuje', null, 200, 710);

-- Czynnoœci administracyjne 1000
insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(1000, 1000, 0, 'Godzina od', 'Godzina od', 0, 'N');
insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(1001, 1000, 0, 'Godzina do', 'Godzina do', 1000, 'N');

	