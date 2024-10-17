### 설문 리스트 스키마
```
DROP TABLE IF EXISTS tblPollList;

CREATE TABLE `tblPollList` (
  `num` smallint(6) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) NOT NULL DEFAULT '',
  `sdate` date DEFAULT NULL,
  `edate` date DEFAULT NULL,
  `wdate` date DEFAULT NULL,
  `type` smallint(6) NOT NULL DEFAULT '1',
  `active` smallint(6) DEFAULT '1',
  PRIMARY KEY (`num`)
);
```

### 설문 항목 스키마
```
DROP TABLE IF EXISTS tblPollItem;

CREATE TABLE `tblPollItem` (
  `listnum` smallint(6) NOT NULL,
  `itemnum` smallint(6) NOT NULL DEFAULT '0',
  `item` varchar(50) NOT NULL DEFAULT '',
  `count` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`listnum`,`itemnum`)
);
```
