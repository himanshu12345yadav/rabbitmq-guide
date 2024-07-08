# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/#build-image)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#messaging.amqp)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Hot reload guide

Using the `spring-dev-tools` dependencies it will automatically reload the project , while the projects using kotlin
needs additional automatic build step to reload it using the spring dev tools.

```bash
.\gradlew -t :bootJar
```

or

```bash
./gradlew -t -P -b -c :bootJar
```

where ,

- `-t` means `--continuous`
- `-P` means `--parallel`
- `-b` means `--build-cache`
- `-c` means `--configuration-cache`

Along , with this start the spring boot application using another terminal

```bash
.\gradlew bootRun --args="--spring.profiles.active=dev"
```

### Use rabbit in docker

To run the rabbit-broker in the docker and application in the host machine.

```bash
docker-compose run -d --service-ports rabbit
```

This will run only the rabbit service using the docker configuration . Note that to enable the port mapping its needed
to use `--service-ports` flag.