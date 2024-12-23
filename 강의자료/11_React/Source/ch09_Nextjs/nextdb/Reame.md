- Root로 계정, db 만들기
```
create user nextuser@localhost identified by '1234';
create database nextdb;
grant all privileges on nextdb.* to nextuser@localhost with grant option;
commit;
----------------------------------------
// nextuser 로그인후 실행...
------------------------------------------
use nextdb;
create table member (
	 id int(11) not null auto_increment,
     name varchar(30) not null,
     email varchar(50) ,
     constraint member_PK primary key(id)
     );

insert into member (name,email)  values("홍길동", "aaa@bb.com");
insert into member (name,email)  values("이순신", "lee@bb.com");
insert into member (name,email)  values("이만세", "man@bb.com");
select * from member;
```

- 패키지 설치
```
--------------------------
npm i --save-dev @types/mysql
npm i mysql2
```
