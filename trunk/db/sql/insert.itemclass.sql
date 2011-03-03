insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(100, 0, 'Y', 'Hardware', 'Klasa bazowa dla wszystkich typ�w sprz�tu');
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(101, 0, 'Y', 'Software', 'Klasa bazowa dla wszystkich typ�w oprogramowania');
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(102, 0, 'Y', 'Dokumenty', 'Klasa bazowa dla wszystkich typ�w dokument�w');
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(103, 0, 'Y', 'Serwery', 'Klasa bazowa dla wszystkich serwer�w');
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(104, 0, 'Y', 'Monitory', 'Klasa bazowa dla wszystkich monitor�w');

insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(100, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(101, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(102, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(103, 100);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(104, 100);