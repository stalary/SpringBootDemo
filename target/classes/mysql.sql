CREATE DATABASE dbgirl;
create table girl
(
	id int auto_increment primary key,
	user_id int null,
	age int null,
	cup_size varchar(1) null,
	money double not null
)ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table user
(
	id int auto_increment primary key,
	username varchar(50) null,
	password varchar(255) null,
	salt varchar(50) null,
	ticket varchar(255) null
)ENGINE =InnoDB DEFAULT CHARSET=utf8;