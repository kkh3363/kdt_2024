create database javadb;
create user juser@localhost identified by 'juser';
grant all privileges on javadb.* to juser@localhost;
commit;


create table users (
	userid   		varchar(50)	  	primary key, 
	username		varchar(50)	  	not null,
	userpassword	varchar(50)	  	not null,
	userage			numeric(3)		not null,
	useremail		varchar(50)	  	not null
);

