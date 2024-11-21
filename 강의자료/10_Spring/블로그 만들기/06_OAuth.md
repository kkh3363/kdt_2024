- build.gradle
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'

	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'
	implementation 'org.springframework.security:spring-security-test'

	testAnnotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.projectlombok:lombok'
	implementation 'io.jsonwebtoken:jjwt:0.9.1'
	implementation 'javax.xml.bind:jaxb-api:2.3.1'
	implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
}
```
- application.properties
```
spring.security.oauth2.client.registration.google.client-id=xxx
spring.security.oauth.client.registration.google.client-secret=xxx
spring.security.oauth.client.registration.google.scope=profile,email
```
