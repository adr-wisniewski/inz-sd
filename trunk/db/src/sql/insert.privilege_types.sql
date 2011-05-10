insert into privilege_types(privilege_code, description) values('ADD_IM', 'Dodawanie incydentow');
insert into privilege_types(privilege_code, description) values('EDIT_IM', 'Edycja incydentow');
insert into privilege_types(privilege_code, description) values('CARD_IM', 'Karta incydentu');
insert into privilege_types(privilege_code, description) values('COMMENT_IM', 'Dodanie komentarza');
insert into privilege_types(privilege_code, description) values('ADD_FOR_IM', 'Wybor pracownika przy dodawaniu incydentow');
insert into privilege_types(privilege_code, description) values('SEARCH_IM', 'Wyszukiwanie incydentow');
insert into privilege_types(privilege_code, description) values('MY_OPEN_IM', 'Moje otwarte incydenty');
insert into privilege_types(privilege_code, description) values('MY_CLOS_IM', 'Moje zamkniete incydenty');
insert into privilege_types(privilege_code, description) values('MENU_IM', 'Menu zarzadzanie incydentami');
insert into privilege_types(privilege_code, description) values('REPORTS_IM', 'Raporty IM');
insert into privilege_types(privilege_code, description) values('ACCEPT_IM', 'Przypisanie incydentu');
insert into privilege_types(privilege_code, description) values('ASSIGN_IM', 'Moje przypisane incydenty');

insert into privilege_types(privilege_code, description) values('ADD_PM', 'Dodawanie problemow');
insert into privilege_types(privilege_code, description) values('EDIT_PM', 'Edycja problemow');
insert into privilege_types(privilege_code, description) values('SEARCH_PM', 'Wyszukiwanie problemow');
insert into privilege_types(privilege_code, description) values('CARD_PM', 'Karta problemu');
insert into privilege_types(privilege_code, description) values('SEARCH_KE', 'Wyszukiwanie znanych bledow');
insert into privilege_types(privilege_code, description) values('MENU_PM', 'Menu zarzadzanie problemami');
insert into privilege_types(privilege_code, description) values('REPORTS_PM', 'Raporty PM');
insert into privilege_types(privilege_code, description) values('ADD_KE', 'Dodawanie znanych bledow');
insert into privilege_types(privilege_code, description) values('ADD_SOL', 'Dodanie rozwiazania');
insert into privilege_types(privilege_code, description) values('ASSOC_I_P', 'Powiazanie problemu z incydentem');

insert into privilege_types(privilege_code, description) values('MENU_EM', 'Menu zarzadzanie zdarzeniami');
insert into privilege_types(privilege_code, description) values('CARD_EM', 'Karta zdarzenia');
insert into privilege_types(privilege_code, description) values('SEARCH_EM', 'Wyszukiwanie zdarzen');
insert into privilege_types(privilege_code, description) values('REPORTS_EM', 'Raporty EM');

insert into privilege_types(privilege_code, description) values('MENU_RF', 'Menu zarzadzanie requestami');
insert into privilege_types(privilege_code, description) values('ADD_RF', 'Dodawanie requestow');
insert into privilege_types(privilege_code, description) values('EDIT_RF', 'Edycja requestu');
insert into privilege_types(privilege_code, description) values('CARD_RF', 'Karta requestu');
insert into privilege_types(privilege_code, description) values('SEARCH_RF', 'Wyszukiwanie requestow');
insert into privilege_types(privilege_code, description) values('REPORTS_RF', 'Raporty RF');

insert into privilege_types(privilege_code, description) values('CMDB_ITEM_VIEW', 'Przegl�danie element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_ITEM_ADD', 'Dodawanie element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_ITEM_EDIT', 'Edycja element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_ITEM_DELETE', 'Usuwanie element�w konfiguracji');

insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIP_VIEW', 'Przegl�danie relacji element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIP_ADD', 'Dodawanie relacji element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIP_EDIT', 'Edycja relacji element�w konfiguracji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIP_DELETE', 'Usuwanie relacji element�w konfiguracji');

insert into privilege_types(privilege_code, description) values('CMDB_ITEMCLASS_VIEW', 'Przegl�danie klas element�w');
insert into privilege_types(privilege_code, description) values('CMDB_ITEMCLASS_ADD', 'Dodawanie klas element�w');
insert into privilege_types(privilege_code, description) values('CMDB_ITEMCLASS_EDIT', 'Edycja klas element�w');
insert into privilege_types(privilege_code, description) values('CMDB_ITEMCLASS_DELETE', 'Usuwanie klas element�w');

insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIPCLASS_VIEW', 'Przegl�danie klas relacji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIPCLASS_ADD', 'Dodawanie klas relacji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIPCLASS_EDIT', 'Edycja klas relacji');
insert into privilege_types(privilege_code, description) values('CMDB_RELATIONSHIPCLASS_DELETE', 'Usuwanie klas relacji');

insert into privilege_types(privilege_code, description) values('CMDB_ATTRIBUTE_VIEW', 'Przegl�danie atrybut�w klas');
insert into privilege_types(privilege_code, description) values('CMDB_ATTRIBUTE_ADD', 'Dodawanie atrybut�w klas');
insert into privilege_types(privilege_code, description) values('CMDB_ATTRIBUTE_EDIT', 'Edycja atrybut�w klas');
insert into privilege_types(privilege_code, description) values('CMDB_ATTRIBUTE_DELETE', 'Usuwanie atrybut�w klas');

insert into privilege_types(privilege_code, description) values('CHANGE_RFC_VIEW', 'Przegl�danie wniosk�w zmian');
insert into privilege_types(privilege_code, description) values('CHANGE_RFC_ADD', 'Dodawanie wniosk�w zmian');
insert into privilege_types(privilege_code, description) values('CHANGE_RFC_EDIT', 'Edycja wniosk�w zmian');
insert into privilege_types(privilege_code, description) values('CHANGE_RFC_DELETE', 'Usuwanie wniosk�w zmian');
insert into privilege_types(privilege_code, description) values('CHANGE_RFC_MANAGE', 'Zarz�dzanie wnioskami zmian');

insert into privilege_types(privilege_code, description) values('ADMIN', 'Administracja');
insert into privilege_types(privilege_code, description) values('COMMON_ANNOUNCEMENT_CRUD', 'Dodawanie/Edycja/Usuwanie og�osze�');


