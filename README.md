# napputil

Features:

1. Crud apis for crew
2. Pagination
3. Unit test
4. Integration test
5. Dockerized the application

Tools/technologies used

1. Java
2. Spring boot (web, data, test)
3. Mongodb
4. Docker
5. Lombok
6. Gradle

Additional tools/technologies used

1. Swagger
    Used for documentation

2. Testcontainer
   Used for integration test. Instead of a database running on the local machine or in a VM for DAO unit tests or end-to-end integration tests that need a database to be present. In this context, the benefit of Testcontainers is that the database always starts in a known state, without any contamination between test runs or on developers' local machines


build:  ./gradlew build

run:  ./gradlew bootRun

run docker instances: sh run.sh

swagger-url: http://localhost:8080/swagger-ui/#/








