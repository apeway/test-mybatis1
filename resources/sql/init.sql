drop database if exists itat_cart;

create database itat_cart;

use itat_cart;

create table t_user(
	id int(11) primary key auto_increment,
	user_name varchar(100),
	password varchar(100),
	nickname varchar(100),
	type int(5)
);
insert into t_user values(1,'admin','123','超级管理员',1);




