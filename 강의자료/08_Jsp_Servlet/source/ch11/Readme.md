- 워크벤치 root 로 접속
         - jspdb  생성
```  
         create user 'jspuser'@'%' identified by '12345678';

          grant all on jspdb.* to jspuser@'%';
```
- 워크벤치 jspuser 로 접속
       - 테이블 생성

