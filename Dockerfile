FROM openjdk:21
WORKDIR /app

COPY build/libs/*.jar app/app.jar

#ENV SPRING_DATASOURCE_URL jdbc:mysql://mysql:3306/dct
#ENV SPRING_DATASOURCE_USERNAME root
#ENV SPRING_DATASOURCE_PASSWORD 3226

EXPOSE 8003
ENTRYPOINT ["java", "-jar", "app/app.jar"]
