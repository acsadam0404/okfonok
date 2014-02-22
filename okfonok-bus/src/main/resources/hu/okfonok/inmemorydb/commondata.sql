        
insert into Role (id, name) values (1, 'USER_ROLE');
insert into Role (id, name) values (2, 'DEV_ROLE');
insert into Role (id, name) values (3, 'ADMIN_ROLE');
insert into User (id, enabled, password, userName, lastName, firstName, email, phoneNumber) values (1, 1, '82b9a701f55b9a48c6083f247beea5c1', 'aacs', 'Ács', 'Ádám', 'acsadam0404@gmail.com', '062012121');
insert into User (id, enabled, password, userName, lastName, firstName, email, phoneNumber) values (2, 1, '82b9a701f55b9a48c6083f247beea5c1', 'test', 'User', 'Test', 'acsadam0404@gmail.com', '062012121');
insert into User_Roles (user_id, role_id) values (1, 1);
insert into User_Roles (user_id, role_id) values (1, 2);
insert into User_Roles (user_id, role_id) values (1, 3);

insert into User_Roles (user_id, role_id) values (2, 1);

insert into Valueset (name, valuesstring) values ('help_category', 'kat1|kat2|kat3|kat4');
insert into Valueset (name, valuesstring) values ('help_mail', 'acsadam0404@gmail.com');
insert into Valueset (name, valuesstring) values ('employ_category', 'alkalmi|időszakos|tartós');

insert into JobCategory (id, main, name, main_id) values (1, 1, 'főkat1', null);
insert into JobCategory (id, main, name, main_id) values (2, 1, 'főkat2', null);
insert into JobCategory (id, main, name, main_id) values (3, 0, 'alkat1', 1);
insert into JobCategory (id, main, name, main_id) values (4, 0, 'alkat2', 1);
insert into JobCategory (id, main, name, main_id) values (5, 0, 'alkat3', 2);