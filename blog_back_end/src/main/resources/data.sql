insert into roles(role) values('Admin');
insert into roles(role) values('User');



insert into users(email,password,username,enabled) values('urolir@gmail.comm','12345','Chloe-Ann Driscoll','TRUE');
insert into users_roles(user_id,role_id) values(1,1);
insert into users_roles(user_id,role_id) values(1,2);
insert into users(email,password,username,enabled) values('phritik.raj.9022o@discovino.com','12345','Wyatt Yates','TRUE');
insert into users_roles(user_id,role_id) values(2,1);
