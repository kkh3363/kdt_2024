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

insert into tblRegister value( 'abcd', '1234', '홍길동','1234','5678','hone@gmail.com', '010-3333-4444','32112','부대동','학생');
