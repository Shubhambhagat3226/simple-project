# Build stage
FROM gradle:8.6-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/your-app-name-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
