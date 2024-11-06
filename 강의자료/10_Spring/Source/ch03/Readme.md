### devtool

1. build.gradle에 의존성 추가
```
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```
2. application.properties에 사용 여부 추가
```
spring.devtools.livereload.enabled=true
spring.devtools.restart.enabled=true
```
3 IntelliJ 환경 설정
- 컴파일러 : 프로젝트 자동 빌드
- 고급 설정: 개발된 애플리케이션 현재 실행 중인 경우 auto-make

4. liveReload++ 설치
   - 크롬 https://chromewebstore.google.com/detail/livereload++/ciehpookapcdlakedibajeccomagbfab
  
