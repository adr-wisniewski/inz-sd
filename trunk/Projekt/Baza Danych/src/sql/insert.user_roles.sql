insert into user_role(user_id, role_code) (select user_id, role_code from users, roles where login like '%' || role_code || '%');
insert into user_role(user_id, role_code) (select user_id, '2_LINE' from users where login like '%GR%');
insert into user_role(user_id, role_code) (select user_id, 'PRB_GR' from users where login like '%GR%');
