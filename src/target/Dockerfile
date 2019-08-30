FROM openjdk:8
ARG JAR_FILE=rest_HelloWorld-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8585
ENTRYPOINT ["java", "-jar", "/app.jar"]
