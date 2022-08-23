# Logging in spring boot

When a file in the classpath has one of the following names, Spring Boot will automatically load it over the default configuration:

- logback-spring.xml
- logback.xml
- logback-spring.groovy
- logback.groovy

### we wrap `RequestBodyAdviceAdapter` and `ResponseBodyAdviceAdapter` to print log of request and reponse

log type in `LoggingServiceImpl` class

```text

REQUEST method=[GET] path=[/person] headers=[application/jsonPostmanRuntime/7.29.2*/*58899ae1-4727-43c7-8ff7-01ebdc264586localhost:8080gzip, deflate, brkeep-alive53]

RESPONSE method=[GET] path=[/person] headers=[application/jsonPostmanRuntime/7.29.2*/*58899ae1-4727-43c7-8ff7-01ebdc264586localhost:8080gzip, deflate, brkeep-alive53] body=[Person(id=1, name=nam, age=13)]

```

API:

    GET http://localhost:8080/person

    GET http://localhost:8080/hello