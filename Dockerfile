FROM amazoncorretto:11-alpine-jdk
MAINTAINER ezeG
COPY target/backEndArgProg-0.0.1-SNAPSHOT.jar backEndArgProg-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backEndArgProg-0.0.1-SNAPSHOT.jar"]
