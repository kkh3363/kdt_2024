create database javadb;
create user juser@localhost identified by 'juser';
grant all privileges on javadb.* to juser@localhost;
commit;



