insert into C2_CLASSES(CLASS_ID, IS_ABSTRACT, NAME, DESCRIPTION) values(1, 'Y', 'Hardware', 'Klasa bazowa dla wszystkich typ�w sprz�tu');
insert into C2_CLASSES(CLASS_ID, IS_ABSTRACT, NAME, DESCRIPTION) values(2, 'Y', 'Software', 'Klasa bazowa dla wszystkich typ�w oprogramowania');
insert into C2_CLASSES(CLASS_ID, IS_ABSTRACT, NAME, DESCRIPTION) values(3, 'Y', 'Dokumenty', 'Klasa bazowa dla wszystkich typ�w dokument�w');
insert into C2_CLASSES(CLASS_ID, IS_ABSTRACT, NAME, DESCRIPTION) values(4, 'Y', 'Serwery', 'Klasa bazowa dla wszystkich serwer�w');
insert into C2_CLASSES(CLASS_ID, IS_ABSTRACT, NAME, DESCRIPTION) values(5, 'Y', 'Monitory', 'Klasa bazowa dla wszystkich monitor�w');


insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(1, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(2, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(3, NULL);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(4, 1);
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(5, 1);