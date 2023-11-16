FROM openjdk:19-jdk-alpine
VOLUME /tmp
COPY ./target/servicio-fraudes-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar","/app.jar"]
