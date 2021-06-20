# ReactJS-SpringBoot-RESTful
Criação de projeto para fim de estudo.
RESTful  - React JS + SpringBoot + Implantado na AWS

Build: Mavem

Dependency: spring-boot-starter-web
            spring-boot-starter-data-jpa
            junit
            mysql-connector-java
            flyway-core
            dozer-core
            jackson-dataformat-xml
            jackson-dataformat-yaml
            lombok
            spring-hateoas
            springfox-boot-starter -> Swagger
			spring-boot-starter-security
			jjwt

plugin: flyway -> mvn flyway:migrate

URL Swagger = http://localhost:8080/swagger-ui/#/

Postman saveToken
var jsonData = JSON.parse(responseBody);
postman.setEnvironmentVariable("bearer_token", jsonData.token);

Mock Populated
https://www.mockaroo.com/