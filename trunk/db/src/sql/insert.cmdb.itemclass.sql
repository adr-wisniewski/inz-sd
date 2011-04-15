insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(100, 0, 'Y', 'Hardware', 'Klasa bazowa dla wszystkich typów sprzêtu');
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(100, NULL);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(110, 0, 'Y', 'Serwer', 'Klasa bazowa dla wszystkich serwerów');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(110, 100);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(111, 0, 'N', 'Serwer wielofunkcyjny', 'Serwer wielofunkcyjny');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(111, 110);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(112, 0, 'N', 'Serwer HTTP', 'Serwer HTTP');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(112, 110);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(113, 0, 'N', 'Serwer FTP', 'Serwer FTP');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(113, 110);
	
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(120, 0, 'Y', 'Monitor', 'Klasa bazowa dla wszystkich monitorów');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(120, 100);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(121, 0, 'N', 'Monitor LCD', 'Monitory LCD');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(121, 120);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(122, 0, 'N', 'Monitor CRT', 'Monitory CRT');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(122, 120);

	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(130, 0, 'Y', 'Urz¹dzenie sieciowe', 'Klasa bazowa dla wszystkich urz¹dzeñ sieciowych');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(130, 100);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(131, 0, 'N', 'Router', 'Router');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(131, 130);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(132, 0, 'N', 'Switch', 'Switch');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(132, 130);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(133, 0, 'N', 'Firewall', 'Firewall');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(133, 130);
		
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(140, 0, 'Y', 'Urz¹dzenie zasilaj¹ce', 'Klasa bazowa dla wszystkich urz¹dzeñ zasilaj¹cych');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(140, 100);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(141, 0, 'N', 'UPS', 'UPS');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(141, 140);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(142, 0, 'N', 'Agregat pr¹dotwórczy', 'Agregat pr¹dotwórczy');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(142, 140);
		

insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(200, 0, 'Y', 'Software', 'Klasa bazowa dla wszystkich typów oprogramowania');
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(200, NULL);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(210, 0, 'Y', 'System operacyjny', 'Klasa bazowa dla wszystkich systemów operacyjnych');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(210, 200);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(211, 0, 'N', 'System Windows', 'System Windows');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(211, 210);
		insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(212, 0, 'N', 'System Linux', 'System Linux');
		insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(212, 210);
	
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(220, 0, 'N', 'Program administracyjny', 'Program administracyjny');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(220, 200);
	
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(230, 0, 'N', 'Program u¿ytkowy', 'Program u¿ytkowy');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(230, 200);

insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(300, 0, 'Y', 'Element us³ugi', 'Klasa bazowa dla wszystkich elementów us³ug');
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(300, NULL);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(310, 0, 'N', 'Domena http', 'Domena http');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(310, 300);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(320, 0, 'N', 'Certyfikat SSL', 'Certyfikat SSL');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(320, 300);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(330, 0, 'N', '£¹cze internetowe', '£¹cze internetowe');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(330, 300);
	
insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(400, 0, 'Y', 'Element infrastruktury', 'Element infrastruktury');
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(400, NULL);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(410, 0, 'N', 'Serwerownia', 'Serwerownia');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(410, 400);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(420, 0, 'N', 'Szafa na serwer (rack)', 'Szafa na serwer');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(420, 400);


insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(700, 0, 'Y', 'Dokument', 'Klasa bazowa dla wszystkich typów dokumentów');
insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(700, NULL);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(710, 0, 'N', 'Licencja na oprogramowanie', 'Licencja na oprogramowanie');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(710, 700);
	insert into C2_CLASSES(CLASS_ID, VERSION, IS_ABSTRACT, NAME, DESCRIPTION) values(770, 0, 'N', 'Inny dokument', 'Inny dokument');
	insert into C2_ITEM_CLASSES(CLASS_ID, PARENT_CLASS_ID) values(770, 700);

-- Hardware 100
insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(1, 100, 0, 'Producent', 'Nazwa producenta', 0, 'Y');
insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(2, 100, 0, 'Model', 'Oznaczenie modelu', 1000, 'Y');
insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(3, 100, 0, 'Numer seryjny', 'Numer seryjny', 1000, 'N');

	-- Monitor 120
	insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(20, 120, 0, 'Przek¹tna', 'Dlugoœæ przek¹tnej monitora w calach', 2000, 'Y');
	insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(21, 120, 0, 'Format', 'Format monitora np. 4:3', 3000, 'N');
	insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(22, 120, 0, 'Rozdzielczoœæ', 'Rozdzielczoœæ w formacie WxH', 4000, 'Y');
	
		-- Monitor LCD 121
		insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(30, 121, 0, 'Matryca', 'Typ matrycy', 5000, 'Y');
		
		-- Monitor CRT 122
		insert into C2_CLASS_ATTRIBUTES(ATTRIBUTE_ID, CLASS_ID, VERSION, NAME, DESCRIPTION, DISPLAY_NO, IS_OVERVIEW) values(40, 122, 0, 'Odœwie¿anie', 'Czêstotliwoœæ odœwie¿ania w Hz', 5000, 'Y');

