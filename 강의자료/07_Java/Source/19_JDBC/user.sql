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

insert into users (userid, username, userpassword, userage,useremail)
values ('spring', '이봄', '1234', 18, 'spring@mycompany.com');
insert into users (userid, username, userpassword, userage, useremail)
values ('summer', '유여름', '12345', 29, 'summer@mycompany.com');
insert into users (userid, username, userpassword,  userage,useremail)
values ('fall', '최가을', '1234', 24, 'fall@mycompany.com');
insert into users (userid, username, userpassword,  userage,useremail)
values ('winter', '한겨울', '12345', 25, 'winter@mycompany.com');
