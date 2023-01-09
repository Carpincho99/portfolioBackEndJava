#
# Build stage
#
FROM maven:3.8.7-amazoncorretto-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /target/backEndArgProg-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080
# EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
