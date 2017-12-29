CREATE DATABASE loginDemo;
create table book
(
  id int auto_increment
    primary key,
  author varchar(255) null,
  title varchar(255) null,
  user_id int null
)ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table user
(
	id int auto_increment primary key,
	username varchar(50) null,
	password varchar(255) null,
	salt varchar(50) null,
	ticket varchar(255) null
)ENGINE =InnoDB DEFAULT CHARSET=utf8;