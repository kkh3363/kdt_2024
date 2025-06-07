### Mysql
- [Mysql Community Server](https://dev.mysql.com/downloads/windows/installer/8.0.html)
- [Draw.io](https://www.drawio.com/)

### Create
```
create user hr@localhost identified by 'hr';
create database hr;


grant all privileges on hr.* to hr@localhost with grant option;
commit;

SET SQL_SAFE_UPDATES = 0;

```

