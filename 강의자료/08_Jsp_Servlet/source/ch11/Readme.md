- 워크벤치 root 로 접속    
         - jspdb  생성
```  
         create user 'jspuser'@'%' identified by '12345678';

          grant all on jspdb.* to jspuser@'%';
```
- 워크벤치 jspuser 로 접속
       - 테이블 생성

```
DROP TABLE IF EXISTS tblRegister;

CREATE TABLE `tblRegister` (
	`id` VARCHAR(20) NOT NULL,
	`pwd` VARCHAR(20) NOT NULL,
	`name` CHAR(6) NULL DEFAULT NULL,
	`num1` CHAR(6) NULL DEFAULT NULL,
	`num2` CHAR(7) NULL DEFAULT NULL,
	`email` VARCHAR(30) NULL DEFAULT NULL,
	`phone` VARCHAR(30) NULL DEFAULT NULL,
	`zipcode` CHAR(5) NULL DEFAULT NULL,
	`address` VARCHAR(60) NULL DEFAULT NULL,
	`job` VARCHAR(30) NULL DEFAULT NULL
);
```
