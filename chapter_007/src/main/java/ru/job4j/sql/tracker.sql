--создание базы данных
create database if is not exists tracker;
--создание таблицы правил
create table rules(
id serial primary key,
name varchar(80),
description varchar(1000)
);
--создание таблицы ролей
create table role(
id serial primary key,
name varchar(80),
description varchar(1000)
);
--создание таблицы отношений роль правило
create table roles_rules(
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);
--создание таблицы пользователей
create table users(
id serial primary key,
name varchar(80),
role int references role(id)
);
--создание таблицы вложений
create table atachs(
id serial primary key,
path_files varchar(300),
item_id int references item(id)
);
--создание таблицы категорий
create table category (
id serial primary key,
name varchar(40),
description varchar(1000)
);
--создание таблицы состояний
create table state(
id serial primary key,
name varchar(80),
description varchar(1000)
);
--создание таблицы заявки
create table item(
id serial primary key,
name varchar(80),
state_id int references state(id),
owner int references users(id),
category_id int references category(id)
);
--создание таблицы коментариев
create table commentars(
id serial primary key,
parent_id int references item(id),
body varchar(1000),
owner int references users(id)
);


insert into rules(name,description) values ('delete','delete');
insert into rules(name,description) values ('create','create');
insert into rules(name,description) values ('update','update');
insert into rules(name,description) values ('read','read');

insert into role(name,description,rules) values ('superadmin','max power');
insert into role(name,description,rules) values ('admin','power');
insert into role(name,description,rules) values ('user','not power');

insert into roles_rules(roles_id, rules_id) values('1','1');
insert into roles_rules(roles_id, rules_id) values('2','2');
insert into roles_rules(roles_id, rules_id) values('3','3');

insert into users (name,role) values ('viktor',3);
insert into users (name,role) values ('dart vader',1);



insert into category (name, description) values ('main','main work');
insert into category (name, description) values ('bag','bag work');


insert into state (name,description) values ('in work','in work in work');
insert into state (name,description) values ('not work','not work not work');

insert into item (name,state_id,owner,category_id) values ('item one',1,1,1;
insert into item (name,state_id,owner,category_id) values ('item two',2,2,2);

insert into atachs(path_files,item_id) values ('c:file',1);
insert into atachs(path_files,item_id) values ('c:file2',2);
insert into atachs(path_files,item_id) values ('c:file3',1);

insert into commentars (parent_id,body,owner) values (1,'Comment one',2);
insert into commentars (parent_id,body,owner) values (2,'Comment two',1);






