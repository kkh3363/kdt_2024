### lombok
- build.gradle
```
dependencies {
    	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    	implementation 'org.springframework.boot:spring-boot-starter-web'
    	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    	testImplementation 'org.springframework.boot:spring-boot-starter-test'
    	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    	implementation 'org.projectlombok:lombok'
    	annotationProcessor 'org.projectlombok:lombok'
    }
```
- aop dependencies
```
implementation 'org.springframework.boot:spring-boot-starter-aop'
```
