FROM openjdk:8
ARG JAR_FILE=@project.artifactId@-@project.version@.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8585
ENTRYPOINT ["java", "-jar", "/app.jar"]
