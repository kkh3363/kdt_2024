### SQL
```
DROP TABLE IF EXISTS tblnews;

CREATE TABLE `tblnews` (
	`aid` INT(11) NOT NULL AUTO_INCREMENT,
	`titel` CHAR(255) NOT NULL,
	`img` varchar(50) NOT NULL,
	`date` DATETIME NOT NULL,
	`content` text NOT NULL,
	PRIMARY KEY (`aid`)
);
```
