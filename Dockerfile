## Build the app
FROM maven:3.8.4-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean package -DskipTests

## Run the app
FROM openjdk:17-jdk-slim
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} /SocialPostHub-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/SocialPostHub-0.0.1-SNAPSHOT.jar"]
