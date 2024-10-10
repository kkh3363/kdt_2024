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
