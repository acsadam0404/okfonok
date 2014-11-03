        
insert into Role (id, name) values (1, 'USER_ROLE');
insert into Role (id, name) values (2, 'DEV_ROLE');
insert into Role (id, name) values (3, 'ADMIN_ROLE');
insert into User (id, enabled, password, userName, lastName, firstName, email, phoneNumber, city, zipcode) values (1, 1, '82b9a701f55b9a48c6083f247beea5c1', 'acsadam0404@gmail.com', 'Ács', 'Ádám', 'acsadam0404@gmail.com', '062012121', 'Boldog', 3016);
insert into User_Roles (user_id, role_id) values (1, 1);
insert into User_Roles (user_id, role_id) values (1, 2);
insert into User_Roles (user_id, role_id) values (1, 3);

insert into ValueStore (id, name, value) values (1, 'help_mail', 'acsadam0404@gmail.com');

insert into Valueset (id, name) values (1, 'help_category');
insert into Valueset (id, name) values (3, 'employ_category');

insert into ValueSetEntry (bkey, valueSet_id) values ('1', 1);
insert into ValueSetEntry (bkey, valueSet_id) values ('2', 1);
insert into ValueSetEntry (bkey, valueSet_id) values ('3', 1);
insert into ValueSetEntry (bkey, valueSet_id) values ('4', 1);

insert into ValueSetEntry (bkey, valueSet_id) values ('1', 3);
insert into ValueSetEntry (bkey, valueSet_id) values ('2', 3);
insert into ValueSetEntry (bkey, valueSet_id) values ('3', 3);

insert into JobCategory (id, main, name, main_id) values (1, 1, 'ezermester', null);
insert into JobCategory (id, main, name, main_id) values (5, 0, 'kisebb otthoni javítás', 1);
insert into JobCategory (id, main, name, main_id) values (3, 0, 'bútor összeszerelés', 1);
insert into JobCategory (id, main, name, main_id) values (4, 0, 'pakolás', 1);

insert into JobCategory (id, main, name, main_id) values (2, 1, 'házvezető', null);
insert into JobCategory (id, main, name, main_id) values (6, 0, 'takarítás', 2);
insert into JobCategory (id, main, name, main_id) values (7, 0, 'mosás', 2);
insert into JobCategory (id, main, name, main_id) values (8, 0, 'vasalás', 2);
insert into JobCategory (id, main, name, main_id) values (9, 0, 'rendrakás', 2);
insert into JobCategory (id, main, name, main_id) values (10, 0, 'főzés', 2);

insert into JobCategory (id, main, name, main_id) values (11, 1, 'otthoni asszisztens (vagy segítség)', null);
insert into JobCategory (id, main, name, main_id) values (12, 0, 'szállítás', 11);
insert into JobCategory (id, main, name, main_id) values (13, 0, 'rendezvényszervezés', 11);
insert into JobCategory (id, main, name, main_id) values (14, 0, 'segítség a mindennapokban', 11);
insert into JobCategory (id, main, name, main_id) values (15, 0, 'segítség egy rendezvényre', 11);


insert into JobCategory (id, main, name, main_id) values (16, 1, 'gyerek felvigyázó', null);
insert into JobCategory (id, main, name, main_id) values (17, 0, 'gyerekre vigyázás', 16);
insert into JobCategory (id, main, name, main_id) values (18, 0, 'gyerek tanítás', 16);

insert into JobCategory (id, main, name, main_id) values (19, 1, 'magántanár', null);
insert into JobCategory (id, main, name, main_id) values (20, 0, 'nyelvtanítás', 19);
insert into JobCategory (id, main, name, main_id) values (21, 0, 'zenetanítás', 19);
insert into JobCategory (id, main, name, main_id) values (22, 0, 'főiskolai/egyetemi tantárgy tanítás', 19);



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
insert into skill (id, name, question, skillGroup) values (4, 'photoshop1', 'Photoshop?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (5, 'photoshop2', 'Photoshop1?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (6, 'photoshop3', 'Photoshop2?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (7, 'photoshop4', 'Photoshop3?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (8, 'photoshop5', 'Photoshop4?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (9, 'photoshop6', 'Photoshop5?', 'szellemi');
insert into skill (id, name, question, skillGroup) values (10, 'photosho7p', 'Photoshop7?', 'szellemi');

insert into advertisement ( 
id ,
        city ,
        other ,
        zipcode ,
        description,
        expiration ,
        homework ,
        jobTime ,
        maxOffer ,
        remuneration ,
        specifiedJobTime ,
        category_id ,
        user_id )
        values (1, 'boldog', 'streeet 19',  3016, 'hirdetés description', {ts '2014-12-05'}, 0,  null, 2000, 'Órabér', 0, 1, 1);
        
        insert into offer (id, ad_id, user_id, offer) values (1, 1, 1, 1500);