- 기본 명령어
```
// 이미지 가져오기
docker pull mysql
// 버전을 표기해서 가져오기
docker pull mysql:8.0.40

docker images
// 컨테이너 만들기
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=1234 -d -p 3366:3306 mysql:8.0.40
docker stop mysql-container
docker start mysql-container
docker restart mysql-container

docker exec -it mysql-container bash

create user jspuser@'%' identified by '1234';
create database jspdb;
grant all privileges on jspdb.* to jspuser@'%' with grant option;
commit;
```
- 컨테이너로 이미지 만들기
```
docker images -a
REPOSITORY              TAG       IMAGE ID       CREATED        SIZE
mysql                   8.0.40    d58ac93387f6   2 months ago   811MB
rockylinux/rockylinux   latest    fc370d748f4c   2 years ago    293MB

docker commit [options] container [Repository[:tab]]
docker commit -a 'maker' -m 'commit mysql' mysql-container commit_mysql:latest
```
