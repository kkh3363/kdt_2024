### Json WebToken
- [jwt.io](https://jwt.io/)
- 
- 의존성 추가 (build.gradle)
```
testAnnotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.projectlombok:lombok'
implementation 'io.jsonwebtoken:jjwt:0.9.1'
implementation 'javax.xml.bind:jaxb-api:2.3.1'
```

- application.properties
```
jwt.issuer=your_email
jwt.secret_key=study-springboot
```

- config/jwt/JwtProperties.java
  
