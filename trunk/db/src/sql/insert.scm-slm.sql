
insert into agreements(AGREEMENT_ID,START_HOUR,END_HOUR,RESOLUTION_TIME,AVAILABILITY) values(1, 1, 24, 48, 90.00);
insert into agreements(AGREEMENT_ID,START_HOUR,END_HOUR,RESOLUTION_TIME,AVAILABILITY) values(2, 1, 24, 48, 98.00);
insert into agreements(AGREEMENT_ID,START_HOUR,END_HOUR,RESOLUTION_TIME,AVAILABILITY) values(3, 1, 24, 48, 99.00);
insert into agreements(AGREEMENT_ID,START_HOUR,END_HOUR,RESOLUTION_TIME,AVAILABILITY) values(4, 1, 24, 48, 99.99);

insert into service_types(service_type_code, name) values('BUSI', 'Business Service');
insert into service_types(service_type_code, name) values('TECH', 'Technical Service');

insert into services (SERVICE_ID,NAME,DESCRIPTION,SERVICE_TYPE_CODE,BUSINESS_IMPACT_CODE,BUSINESS_PRIORITY_CODE,AGREEMENT_ID)
values(1, 'Free Hosting', 'Free web hosting is best suited for small sites with low traffic, like personal sites. It is not recommended for high traffic or for real business. Technical support is often limited, and technical options are few.', 'BUSI', 'LOW', 'LOW', 1);

insert into services (SERVICE_ID,NAME,DESCRIPTION,SERVICE_TYPE_CODE,BUSINESS_IMPACT_CODE,BUSINESS_PRIORITY_CODE,AGREEMENT_ID)
values(2, 'Shared Hosting', 'Shared hosting is very cost effective. With shared hosting, your web site gets its own domain name, and is hosted on a powerful server along with maybe 100 other web sites. Shared solutions often offer multiple software solutions like e-mail, database, and different editing options. Technical support tends to be good.', 'BUSI', 'LOW', 'LOW', 2);

insert into services (SERVICE_ID,NAME,DESCRIPTION,SERVICE_TYPE_CODE,BUSINESS_IMPACT_CODE,BUSINESS_PRIORITY_CODE,AGREEMENT_ID)
values(3, 'Dedicated Hosting', 'With dedicated hosting, your web site is hosted on a dedicated server. Dedicated hosting is the most expensive option. This option is best suited for large web sites with high traffic, and web sites that use special software. You should expect dedicated hosting to be very powerful and secure, with almost unlimited software solutions.', 'BUSI', 'HIGH', 'HIGH', 3);

insert into services (SERVICE_ID,NAME,DESCRIPTION,SERVICE_TYPE_CODE,BUSINESS_IMPACT_CODE,BUSINESS_PRIORITY_CODE,AGREEMENT_ID)
values(4, 'Collocated Hosting', 'Collocated hosting lets you place your own web server on the premises (locations) of a service provider. This is pretty much the same as running your own server in your own office, only that it is located at a place better designed for it.', 'BUSI', 'HIGH', 'HIGH', 4);