FROM openjdk:17-jdk-slim
 WORKDIR /app
 COPY gradlew .
 COPY gradlew.bat .
 COPY gradle ./gradle
 RUN chmod +x gradlew
 COPY src ./src
 RUN ./gradlew clean build -x test
 RUN mkdir -p build/libs
 RUN cp build/libs/*.jar build/libs/app.jar
 ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]
 EXPOSE 8003

## Use a base image with Java and Maven pre-installed
#FROM openjdk:17-jdk-slim
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the Gradle wrapper files
#COPY shubhambhagat3226-simple-project/gradlew .
#COPY shubhambhagat3226-simple-project/gradlew.bat .
#COPY shubhambhagat3226-simple-project/gradle ./gradle
#
## Make the gradlew executable
#RUN chmod +x gradlew
#
## Copy the project source code
#COPY shubhambhagat3226-simple-project/src ./src
#
## Build the application using Gradle
## Pre-download dependencies to cache them in a layer.  This speeds up subsequent builds.
#RUN ./gradlew clean build -x test
#
## Create a directory for the final JAR file
#RUN mkdir -p build/libs
#
## Copy the JAR file to the build directory.  The exact name might vary depending on your build config.
## Adjust the source path if necessary.  This assumes the jar is created in build/libs
#RUN cp build/libs/*.jar build/libs/app.jar
#
## Specify the command to run when the container starts
#ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]
#
#
## Optional: Expose the port your application runs on
#EXPOSE 8003