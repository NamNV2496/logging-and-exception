# Logging in spring boot

When a file in the classpath has one of the following names, Spring Boot will automatically load it over the default configuration:

## *WAY 1:* ## 

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

```textmate

%d – outputs the time that the log message occurred in formats that SimpleDateFormat allows.
%thread – outputs the name of the thread that the log message occurred in.
$-5level – outputs the logging level of the log message.
%logger{36} – outputs the package + class name the log message occurred in. The number inside the brackets represents the maximum length of the package + class name. If the output is longer than the specified length, it will take a substring of the first character of each individual package starting from the root package until the output is below the maximum length. The class name will never be reduced. A nice diagram of this can be found in the Conversion Word docs.
%M – outputs the name of the method that the log message occurred in (apparently this is quite slow to use and not recommended unless you're not worried about performance, or if the method name is particularly important to you).
%msg – outputs the actual log message.
%n – line break.
%magenta() – sets the color of the output contained in the brackets to magenta (other colors are available).
highlight() – sets the color of the output contained in the brackets depending on the logging level (for example ERROR = red).
```

## *WAY 2: SLEUTH* ## 

```text
    <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-sleuth</artifactId>
            <version>3.1.4</version>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
config on POM and remove logback-spring.xml

### Note: ### We can't migrate logbak with Sleuth 

[Reference](https://dzone.com/articles/configuring-logback-with-spring-boot)