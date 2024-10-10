```
DROP TABLE IF EXISTS tblMember;

CREATE TABLE `tblMember` (
  `id` char(20) NOT NULL,
  `pwd` char(20) NOT NULL,
  `name` char(20) NOT NULL,
  `gender` char(1) NOT NULL,
  `birthday` char(6) NOT NULL,
  `email` char(30) NOT NULL,
  `zipcode` char(5) NOT NULL,
  `address` char(50) NOT NULL,
  `hobby` char(5) NOT NULL,
  `job` char(20) NOT NULL,
  PRIMARY KEY (`id`)
);
```
- 우편번호
```
  DROP TABLE IF EXISTS tblZipcode;

CREATE TABLE `tblZipcode` (
  `zipcode` char(5) NOT NULL,
  `area1` char(10) DEFAULT NULL,
  `area2` char(20) DEFAULT NULL,
  `area3` char(30) DEFAULT NULL
);

```
