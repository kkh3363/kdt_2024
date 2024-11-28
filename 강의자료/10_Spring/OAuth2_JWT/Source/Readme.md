### application.properties
```
#registration
spring.security.oauth2.client.registration.서비스명.client-name=서비스명
spring.security.oauth2.client.registration.서비스명.client-id=서비스에서 발급 받은 아이디
spring.security.oauth2.client.registration.서비스명.client-secret=서비스에서 발급 받은 비밀번호
spring.security.oauth2.client.registration.서비스명.redirect-uri=서비스에 등록한 우리쪽 로그인 성공 URI
spring.security.oauth2.client.registration.서비스명.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.서비스명.scope=리소스 서버에서 가져올 데이터 범위

#provider
spring.security.oauth2.client.provider.서비스명.authorization-uri=서비스 로그인 창 주소
spring.security.oauth2.client.provider.서비스명.token-uri=토큰 발급 서버 주소
spring.security.oauth2.client.provider.서비스명.user-info-uri=사용자 정보 획득 주소
spring.security.oauth2.client.provider.서비스명.user-name-attribute=응답 데이터 변수
```
- naver
```
#registration
spring.security.oauth2.client.registration.naver.client-name=naver
spring.security.oauth2.client.registration.naver.client-id=발급아이디
spring.security.oauth2.client.registration.naver.client-secret=발급비밀번호
spring.security.oauth2.client.registration.naver.redirect-uri=http://localhost:8080/login/oauth2/code/naver
spring.security.oauth2.client.registration.naver.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.naver.scope=name,email

#provider
spring.security.oauth2.client.provider.naver.authorization-uri=https://nid.naver.com/oauth2.0/authorize
spring.security.oauth2.client.provider.naver.token-uri=https://nid.naver.com/oauth2.0/token
spring.security.oauth2.client.provider.naver.user-info-uri=https://openapi.naver.com/v1/nid/me
spring.security.oauth2.client.provider.naver.user-name-attribute=response
```
