docker pull mysql

docker pull mysql:8.0.40

docker images

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=1234 -d -p 3366:3306 mysql:8.0.40
docker stop mysql-container
docker start mysql-container
docker restart mysql-container

docker exec -it mysql-container bash

create user jspuser@'%' identified by '1234';
create database jspdb;
grant all privileges on jspdb.* to jspuser@'%' with grant option;
commit;
