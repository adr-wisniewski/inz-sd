insert into employee_role(employee_id, role_code) (select employee_id, role_code from employees, roles where login like '%' || role_code || '%');
insert into employee_role(employee_id, role_code) (select employee_id, '2_LINE' from employees where login like '%GR%');
insert into employee_role(employee_id, role_code) (select employee_id, 'PRB_GR' from employees where login like '%GR%');
