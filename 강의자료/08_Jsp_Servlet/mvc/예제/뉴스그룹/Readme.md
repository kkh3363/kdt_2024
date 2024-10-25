### SQL
```
DROP TABLE IF EXISTS tblnews;

CREATE TABLE `tblnews` (
	`aid` INT(11) NOT NULL AUTO_INCREMENT,
	`title` CHAR(255) NOT NULL,
	`img` varchar(50) NOT NULL,
	`date` DATETIME NOT NULL,
	`content` text NOT NULL,
	PRIMARY KEY (`aid`)
);

insert into tblnews  values( 1, '제목1', "",now(),"내용1");
insert into tblnews values( 2, '제목2', "",now(),"내용2");
insert into tblnews values( 3, '제목3', "",now(),"내용3");
insert into tblnews values( 4, '제목4', "",now(),"내용4");
insert into tblnews values( 5, '제목5', "",now(),"내용5");

```

1. newsList.jsp
2. newsView.jsp

3. News.java
4. NewsDao.java
