FROM amazoncorretto:17-alpine-jdk
MAINTAINER ezequiel_giorgis
COPY ./target/backEndArgProg-0.0.1-SNAPSHOT.jar backEndArgProg-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","backEndArgProg-0.0.1-SNAPSHOT.jar"]
