# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/#build-image)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#web.spring-hateoas)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

swagger using springfox, should enable mvc 
on prod should set swagger false to hide it

http://localhost:8080/swagger-ui/index.html


carefull with lombok library, try update project every change in code that used lombok library!!!


https://medium.com/predictly-on-tech/spring-data-jpa-batching-using-streams-af456ea611fc
https://stackoverflow.com/questions/12206600/how-to-speed-up-insertion-performance-in-postgresql

https://bootify.io/spring-rest/rest-api-spring-security-with-jwt.html
https://www.codejava.net/frameworks/spring-boot/spring-security-jwt-authentication-tutorial

https://spring.io/guides/gs/accessing-mongodb-data-rest/
mongo on docker

docker pull mongo

docker run --name mongodb -v /Users/didietekapermana/Documents/data/MongoDB/data:/data/db -p 27017:27017 -d mongo


https://stackoverflow.com/questions/44755839/equivalents-for-mvn-update-and-mvn-install-in-gradle


build
mvn clean install ~= ./gradlew clean build -x test

just build
./gradlew build

build without test
./gradlew build -x test

https://spring.io/guides/gs/spring-boot-docker/
https://medium.com/geekculture/how-to-dockerize-java-spring-boot-api-mongo-db-2ad5561a2592