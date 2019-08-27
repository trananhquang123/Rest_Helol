FROM openjdk:8
ADD target/app-postgres.jar app-postgres.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app-postgres.jar"]