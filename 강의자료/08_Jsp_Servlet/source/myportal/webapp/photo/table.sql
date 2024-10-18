DROP TABLE IF EXISTS tblPMember;

CREATE TABLE `tblPMember` (
	`id` CHAR(20) NOT NULL,
	`pwd` CHAR(20) NOT NULL,
	`name` CHAR(20) NOT NULL,
	`profile` CHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);
