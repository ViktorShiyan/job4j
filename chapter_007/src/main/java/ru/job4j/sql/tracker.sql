--создание базы данных
--create database if is not exists tracker;
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
description varchar(1000),
rules int references rules(id)
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
path_files varchar(300)
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
atachs_id int references atachs(id),
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

insert into role(name,description,rules) values ('superadmin','max power',1);
insert into role(name,description,rules) values ('admin','power',2);
insert into role(name,description,rules) values ('user','not power',4);

insert into users (name,role) values ('viktor',3);
insert into users (name,role) values ('dart vader',1);

insert into atachs(path_files) values ('c:file');
insert into atachs(path_files) values ('c:file2');
insert into atachs(path_files) values ('c:file3');


insert into category (name, description) values ('main','main work');
insert into category (name, description) values ('bag','bag work');


insert into state (name,description) values ('in work','in work in work');
insert into state (name,description) values ('not work','not work not work');

insert into item (name,state_id,owner,atachs_id,category_id) values ('item one',1,1,1,1);
insert into item (name,state_id,owner,atachs_id,category_id) values ('item two',2,2,2,2);

insert into commentars (parent_id,body,owner) values (1,'Comment one',2);
insert into commentars (parent_id,body,owner) values (2,'Comment two',1);






