FROM amazoncorretto:17
MAINTAINER eze
COPY ./target/backEndArgProg-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
