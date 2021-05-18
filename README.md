# ProducServer API

Simple Api for CRUD Products using [Spring Boot](http://projects.spring.io/spring-boot/).

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Set enviroment credentials database
Set config inside file `src/main/resources/application.properties` set credentials to connect to db.

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.productserver.main.ProductserviceApplication` class from your IDE.
Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:
```shell
mvn spring-boot:run
```


## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
