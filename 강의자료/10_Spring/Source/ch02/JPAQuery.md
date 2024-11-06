- build.gradle
```
  implementation 'com.querydsl:querydsl-apt:5.0.0'
	implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
	implementation 'com.querydsl:querydsl-core:5.0.0'

  annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jakarta"
	annotationProcessor "jakarta.annotation:jakarta.annotation-api"
	annotationProcessor "jakarta.persistence:jakarta.persistence-api"
```
