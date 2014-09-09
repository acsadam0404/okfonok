        
insert into Role (id, name) values (1, 'USER_ROLE');
insert into Role (id, name) values (2, 'DEV_ROLE');
insert into Role (id, name) values (3, 'ADMIN_ROLE');
insert into User (id, enabled, password, userName, lastName, firstName, email, phoneNumber) values (1, 1, '82b9a701f55b9a48c6083f247beea5c1', 'acsadam0404@gmail.com', 'Ács', 'Ádám', 'acsadam0404@gmail.com', '062012121');
insert into User_Roles (user_id, role_id) values (1, 1);
insert into User_Roles (user_id, role_id) values (1, 2);
insert into User_Roles (user_id, role_id) values (1, 3);

insert into User_Roles (user_id, role_id) values (2, 1);

insert into ValueStore (id, name, value) values (1, 'help_mail', 'acsadam0404@gmail.com');

insert into Valueset (id, name) values (1, 'help_category');
insert into Valueset (id, name) values (3, 'employ_category');

insert into ValueSetEntry (key, valueSet_id) values ('1', 1);
insert into ValueSetEntry (key, valueSet_id) values ('2', 1);
insert into ValueSetEntry (key, valueSet_id) values ('3', 1);
insert into ValueSetEntry (key, valueSet_id) values ('4', 1);

insert into ValueSetEntry (key, valueSet_id) values ('1', 3);
insert into ValueSetEntry (key, valueSet_id) values ('2', 3);
insert into ValueSetEntry (key, valueSet_id) values ('3', 3);

insert into JobCategory (id, main, name, main_id) values (1, 1, 'főkat1', null);
insert into JobCategory (id, main, name, main_id) values (2, 1, 'főkat2', null);
insert into JobCategory (id, main, name, main_id) values (3, 0, 'alkat1', 1);
insert into JobCategory (id, main, name, main_id) values (4, 0, 'alkat2', 1);
insert into JobCategory (id, main, name, main_id) values (5, 0, 'alkat3', 2);


insert into Point (id, sum, datum) values (1, 15, {ts '2014-07-05'});
insert into Point (id, sum, datum) values (2, 30, {ts '2014-07-06'});
insert into Point (id, sum, datum) values (3, 10, {ts '2014-07-07'});
insert into Point (id, sum, datum) values (4, 20, {ts '2014-07-08'});

insert into User_Points (user_id, point_id) values (1, 1);
insert into User_Points (user_id, point_id) values (1, 2);
insert into User_Points (user_id, point_id) values (1, 3);
insert into User_Points (user_id, point_id) values (1, 4);


insert into skill (id, name, question, skillGroup) values (1, 'Kalapácsolás', 'Tudsz-e kalapácsolni?', 'fizikai');
insert into skill (id, name, question, skillGroup) values (2, 'Kódolás', 'Tudsz-e programozni?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (3, 'fúrás', 'Tudsz-e fúrni?', 'fizikai');
insert into skill (id, name, question, skillGroup) values (4, 'photoshop', 'Photoshop?', 'szellemi');