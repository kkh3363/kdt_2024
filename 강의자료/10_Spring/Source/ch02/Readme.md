

```
create user shopuser@localhost identified by '1234';
create database shopdb;
grant all privileges on shopdb.* to shopuser@localhost with grant option;
commit;
```
