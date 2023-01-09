#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
# EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
